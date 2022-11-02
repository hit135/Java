package ch12_exception_git;

public class MyException extends Exception{
	// 에러코드는 넣어주자!
	private String errCode;

	public MyException() {}
	
	public MyException(String errCode) {
		super();
		this.errCode = errCode;
	}
	
	public MyException(String errMsg, String errCode) {
		super(errMsg);
		this.errCode = errCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	
	
	
	

}
