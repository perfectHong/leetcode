package io;
 
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;
 
/**
 * 服务器端(tomcat)：
1、使用SocketServer创建一个套接字连接服务。
2、监听端口号，例如这里的8080端口。
3、通过套接字服务，获取inputStream输入流，可以理解为request。
4、通过输入流(request)获取请求的信息。
5、处理获取出来的输入流信息，使用反射生成访问的处理类对象，用来调用访问的方法。
6、通过套接字得到outputStream输出流，可以理解成response，通过输出流给出响应信息。

以上就是模拟实现获取请求和给出响应的实现原理。


客户端(浏览器访问)：
1、使用Socket创建一个连接，访问一个路径和一个端口号，也就是用户在浏览器中输入网址的过程。
2、使用socket获取输出流，这里的输出流可以理解成request对象。
3、如果要获取发服务器响应的内容则通过，socket获取inputStream输入流，读取管道中的数据就可以。


以上就是模拟浏览器发出请求并接受响应的过程。
 * */
public class TomcatServer {
 
    private final static int PORT = 8080;
 
    public static void main(String[] args) {
 
        try {
            ServerSocket server = new ServerSocket(PORT);//根据端口号启动一个serverSocket
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
                    client = server.accept();//ServerSocket阻塞等待客户端请求数据
                    if (client != null) {
                        try {
                            System.out.println("接收到一个客户端的请求");
 
                            //根据客户端的Socket对象获取输入流对象。
                            //封装字节流到字符流
                            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
 
                            // GET /test.jpg /HTTP1.1
                            //http请求由三部分组成，分别是：请求行、消息报头、请求正文。
                            //这里取的第一行数据就是请求行。http协议详解可以参考http://www.cnblogs.com/li0803/archive/2008/11/03/1324746.html说的很详细
                            String line = reader.readLine();
 
                            System.out.println("line: " + line);
 
                            //拆分http请求路径，取http需要请求的资源完整路径
                            String resource = line.substring(line.indexOf('/'),line.lastIndexOf('/') - 5);
 
                            System.out.println("the resource you request is: "+ resource);
 
                            resource = URLDecoder.decode(resource, "UTF-8");
 
                            //获取到这次请求的方法类型，比如get或post请求
                            String method = new StringTokenizer(line).nextElement().toString();
 
                            System.out.println("the request method you send is: "+ method);
 
                            //继续循环读取浏览器客户端发出的一行一行的数据
                            while ((line = reader.readLine()) != null) {
                                if (line.equals("")) {//当line等于空行的时候标志Header消息结束
                                    break;
                                }
                                System.out.println("the Http Header is : " + line);
                            }
 
                            //如果是POST的请求，直接打印POST提交上来的数据
                            if ("post".equals(method.toLowerCase())) {
                                System.out.println("the post request body is: "
                                        + reader.readLine());
                            }else if("get".equals(method.toLowerCase())){
                                //判断是get类型的http请求处理
                                //根据http请求的资源后缀名来确定返回数据
 
                                //比如下载一个图片文件，我这里直接给定一个图片路径来模拟下载的情况
                                if (resource.endsWith(".jpg")) {
                                    transferFileHandle("d://123.jpg", client);
                                    closeSocket(client);
                                    continue;
 
                                } else {
 
                             //直接返回一个网页数据
                             //其实就是将html的代码以字节流的形式写到IO中反馈给客户端浏览器。
                             //浏览器会根据http报文“Content-Type”来知道反馈给浏览器的数据是什么格式的，并进行什么样的处理
 
                             PrintStream writer = new PrintStream(client.getOutputStream(), true);
                             writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                             writer.println("Content-Type:text/html;charset=utf-8");
                             writer.println();
                             //writer.println("Content-Length:" + html.getBytes().length);// 返回内容字节数
                             writer.println("<html><body>");
                             writer.println("<a href='www.baidu.com'>百度</a>");
                             writer.println("<img src='https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png'></img>");
                             writer.println("</html></body>");
 
 
                             //writer.println("HTTP/1.0 404 Not found");// 返回应答消息,并结束应答
                             writer.println();// 根据 HTTP 协议, 空行将结束头信息
                             writer.close();
                             closeSocket(client);//请求资源处理完毕，关闭socket链接
                             continue;
                                }
                            }
 
 
 
                        } catch (Exception e) {
                            System.out.println("HTTP服务器错误:"
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
            System.out.println(socket + "离开了HTTP服务器");
        }
 
        private void transferFileHandle(String path, Socket client) {
 
            File fileToSend = new File(path);
 
            if (fileToSend.exists() && !fileToSend.isDirectory()) {
                try {
                    //根据Socket获取输出流对象，将访问的资源数据写入到输出流中
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                    writer.println("Content-Type:application/binary");
                    writer.println("Content-Length:" + fileToSend.length());// 返回内容字节数
                    writer.println();// 根据 HTTP 协议, 空行将结束头信息
 
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