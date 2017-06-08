package hellofood.actions;

import com.web.BaseAction;

public class AjaxJsonAction extends BaseAction{
	
	private String dummyMsg;

	public String getDummyMsg() {
		return dummyMsg;
	}

	public void setDummyMsg(String dummyMsg) {
		this.dummyMsg = dummyMsg;
	}
	
	public String execute(){
		dummyMsg="OOOOOOOOOOOOOOOOOOO";
		
		return SUCCESS;
	}


}
