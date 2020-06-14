package io;
 
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;
 
/**
 * ��������(tomcat)��
1��ʹ��SocketServer����һ���׽������ӷ���
2�������˿ںţ����������8080�˿ڡ�
3��ͨ���׽��ַ��񣬻�ȡinputStream���������������Ϊrequest��
4��ͨ��������(request)��ȡ�������Ϣ��
5�������ȡ��������������Ϣ��ʹ�÷������ɷ��ʵĴ���������������÷��ʵķ�����
6��ͨ���׽��ֵõ�outputStream���������������response��ͨ�������������Ӧ��Ϣ��

���Ͼ���ģ��ʵ�ֻ�ȡ����͸�����Ӧ��ʵ��ԭ��


�ͻ���(���������)��
1��ʹ��Socket����һ�����ӣ�����һ��·����һ���˿ںţ�Ҳ�����û����������������ַ�Ĺ��̡�
2��ʹ��socket��ȡ�������������������������request����
3�����Ҫ��ȡ����������Ӧ��������ͨ����socket��ȡinputStream����������ȡ�ܵ��е����ݾͿ��ԡ�


���Ͼ���ģ��������������󲢽�����Ӧ�Ĺ��̡�
 * */
public class TomcatServer {
 
    private final static int PORT = 8080;
 
    public static void main(String[] args) {
 
        try {
            ServerSocket server = new ServerSocket(PORT);//���ݶ˿ں�����һ��serverSocket
            ServletHandler servletHandler=new ServletHandler(server);
            servletHandler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
 
 
    private static class ServletHandler extends Thread{
        ServerSocket server=null;
        public ServletHandler(ServerSocket server){
            this.server=server;
        }
 
 
        @Override
        public void run() {
            while (true) {
                try {
                    Socket client = null;
                    client = server.accept();//ServerSocket�����ȴ��ͻ�����������
                    if (client != null) {
                        try {
                            System.out.println("���յ�һ���ͻ��˵�����");
 
                            //���ݿͻ��˵�Socket�����ȡ����������
                            //��װ�ֽ������ַ���
                            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
 
                            // GET /test.jpg /HTTP1.1
                            //http��������������ɣ��ֱ��ǣ������С���Ϣ��ͷ���������ġ�
                            //����ȡ�ĵ�һ�����ݾ��������С�httpЭ�������Բο�http://www.cnblogs.com/li0803/archive/2008/11/03/1324746.html˵�ĺ���ϸ
                            String line = reader.readLine();
 
                            System.out.println("line: " + line);
 
                            //���http����·����ȡhttp��Ҫ�������Դ����·��
                            String resource = line.substring(line.indexOf('/'),line.lastIndexOf('/') - 5);
 
                            System.out.println("the resource you request is: "+ resource);
 
                            resource = URLDecoder.decode(resource, "UTF-8");
 
                            //��ȡ���������ķ������ͣ�����get��post����
                            String method = new StringTokenizer(line).nextElement().toString();
 
                            System.out.println("the request method you send is: "+ method);
 
                            //����ѭ����ȡ������ͻ��˷�����һ��һ�е�����
                            while ((line = reader.readLine()) != null) {
                                if (line.equals("")) {//��line���ڿ��е�ʱ���־Header��Ϣ����
                                    break;
                                }
                                System.out.println("the Http Header is : " + line);
                            }
 
                            //�����POST������ֱ�Ӵ�ӡPOST�ύ����������
                            if ("post".equals(method.toLowerCase())) {
                                System.out.println("the post request body is: "
                                        + reader.readLine());
                            }else if("get".equals(method.toLowerCase())){
                                //�ж���get���͵�http������
                                //����http�������Դ��׺����ȷ����������
 
                                //��������һ��ͼƬ�ļ���������ֱ�Ӹ���һ��ͼƬ·����ģ�����ص����
                                if (resource.endsWith(".jpg")) {
                                    transferFileHandle("d://123.jpg", client);
                                    closeSocket(client);
                                    continue;
 
                                } else {
 
                             //ֱ�ӷ���һ����ҳ����
                             //��ʵ���ǽ�html�Ĵ������ֽ�������ʽд��IO�з������ͻ����������
                             //����������http���ġ�Content-Type����֪���������������������ʲô��ʽ�ģ�������ʲô���Ĵ���
 
                             PrintStream writer = new PrintStream(client.getOutputStream(), true);
                             writer.println("HTTP/1.0 200 OK");// ����Ӧ����Ϣ,������Ӧ��
                             writer.println("Content-Type:text/html;charset=utf-8");
                             writer.println();
                             //writer.println("Content-Length:" + html.getBytes().length);// ���������ֽ���
                             writer.println("<html><body>");
                             writer.println("<a href='www.baidu.com'>�ٶ�</a>");
                             writer.println("<img src='https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png'></img>");
                             writer.println("</html></body>");
 
 
                             //writer.println("HTTP/1.0 404 Not found");// ����Ӧ����Ϣ,������Ӧ��
                             writer.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
                             writer.close();
                             closeSocket(client);//������Դ������ϣ��ر�socket����
                             continue;
                                }
                            }
 
 
 
                        } catch (Exception e) {
                            System.out.println("HTTP����������:"
                                    + e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
 
        private void closeSocket(Socket socket) {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(socket + "�뿪��HTTP������");
        }
 
        private void transferFileHandle(String path, Socket client) {
 
            File fileToSend = new File(path);
 
            if (fileToSend.exists() && !fileToSend.isDirectory()) {
                try {
                    //����Socket��ȡ��������󣬽����ʵ���Դ����д�뵽�������
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("HTTP/1.0 200 OK");// ����Ӧ����Ϣ,������Ӧ��
                    writer.println("Content-Type:application/binary");
                    writer.println("Content-Length:" + fileToSend.length());// ���������ֽ���
                    writer.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
 
                    FileInputStream fis = new FileInputStream(fileToSend);
                    byte[] buf = new byte[fis.available()];
                    fis.read(buf);
                    writer.write(buf);
                    writer.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
    }
 
}