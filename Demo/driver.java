class driver{
	public static void main(String[] args){
		String currdir = System.getProperty("user.dir");
		pAscii m = new pAscii(currdir+"/../pic.jpg");
		m.printAscii();
	}
}
