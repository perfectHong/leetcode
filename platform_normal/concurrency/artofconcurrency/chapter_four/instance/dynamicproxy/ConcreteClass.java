package concurrency.artofconcurrency.chapter_four.instance.dynamicproxy;

/**
 * 这个实现类是非必须的
 * */
class ConcreteClass implements JavaProxyInterface {
	
	@Override
	public void gotoSchool() {
		System.out.println("gotoSchool");
	}

	@Override
	public void gotoWork() {
		System.out.println("gotoWork");
	}

	@Override
	public void oneDay() {
		gotoSchool();
		gotoWork();
	}

	@Override
	public final void oneDayFinal() {
		gotoSchool();
		gotoWork();
	}
}
