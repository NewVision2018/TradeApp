package tradingapp5;

import java.util.ArrayList;
import java.util.List;

public class TradeReceiptPojo {
	
	String[] comboBox = {};
	
	String[] textFieldForHsn = {};
	
	List<String> textFieldForQty = new ArrayList<String>();
	
	List<String> textFieldForRate = new ArrayList<String>();
	
	List<String> textFieldForMrp = new ArrayList<String>();
	
	List<String> textFieldForValue = new ArrayList<String>();
	
	String textFieldTo = "";
	String textAreaAddress = "";
	String textFieldGstin = "";
	
	String textFieldSubTotal = "";
	String textFieldTotalQty = "";
	String textFieldGrandTotal = "";
	
	String textFieldBillNo = "";
	String textFieldDate = "";
	
	String textAreaSpace = "";
	
	String labelTitle1 = "";
	String labelTitle2 = "";
	String labelTitle3 = "";
	
	String lblNumberToWord = "";
	
	String companySignature = "";
	
	public String[] getComboBox() {
		return comboBox;
	}



	public void setComboBox(String[] comboBox) {
		this.comboBox = comboBox;
	}



	public String[] getTextFieldForHsn() {
		return textFieldForHsn;
	}



	public void setTextFieldForHsn(String[] textFieldForHsn) {
		this.textFieldForHsn = textFieldForHsn;
	}
	


	public List<String> getTextFieldForQty() {
		return textFieldForQty;
	}



	public void setTextFieldForQty(List<String> textFieldForQty) {
		this.textFieldForQty = textFieldForQty;
	}



	public List<String> getTextFieldForRate() {
		return textFieldForRate;
	}



	public void setTextFieldForRate(List<String> textFieldForRate) {
		this.textFieldForRate = textFieldForRate;
	}



	public List<String> getTextFieldForMrp() {
		return textFieldForMrp;
	}



	public void setTextFieldForMrp(List<String> textFieldForMrp) {
		this.textFieldForMrp = textFieldForMrp;
	}



	public List<String> getTextFieldForValue() {
		return textFieldForValue;
	}



	public void setTextFieldForValue(List<String> textFieldForValue) {
		this.textFieldForValue = textFieldForValue;
	}



	public String getTextFieldTo() {
		return textFieldTo;
	}



	public void setTextFieldTo(String textFieldTo) {
		this.textFieldTo = textFieldTo;
	}



	public String getTextAreaAddress() {
		return textAreaAddress;
	}



	public void setTextAreaAddress(String textAreaAddress) {
		this.textAreaAddress = textAreaAddress;
	}



	public String getTextFieldGstin() {
		return textFieldGstin;
	}



	public void setTextFieldGstin(String textFieldGstin) {
		this.textFieldGstin = textFieldGstin;
	}



	public String getTextFieldSubTotal() {
		return textFieldSubTotal;
	}



	public void setTextFieldSubTotal(String textFieldSubTotal) {
		this.textFieldSubTotal = textFieldSubTotal;
	}



	public String getTextFieldTotalQty() {
		return textFieldTotalQty;
	}



	public void setTextFieldTotalQty(String textFieldTotalQty) {
		this.textFieldTotalQty = textFieldTotalQty;
	}



	public String getTextFieldGrandTotal() {
		return textFieldGrandTotal;
	}



	public void setTextFieldGrandTotal(String textFieldGrandTotal) {
		this.textFieldGrandTotal = textFieldGrandTotal;
	}



	public String getTextFieldBillNo() {
		return textFieldBillNo;
	}



	public void setTextFieldBillNo(String textFieldBillNo) {
		this.textFieldBillNo = textFieldBillNo;
	}



	public String getTextFieldDate() {
		return textFieldDate;
	}



	public void setTextFieldDate(String textFieldDate) {
		this.textFieldDate = textFieldDate;
	}



	public String getTextAreaSpace() {
		return textAreaSpace;
	}



	public void setTextAreaSpace(String textAreaSpace) {
		this.textAreaSpace = textAreaSpace;
	}



	public String getLabelTitle1() {
		return labelTitle1;
	}



	public void setLabelTitle1(String labelTitle1) {
		this.labelTitle1 = labelTitle1;
	}



	public String getLabelTitle2() {
		return labelTitle2;
	}



	public void setLabelTitle2(String labelTitle2) {
		this.labelTitle2 = labelTitle2;
	}



	public String getLabelTitle3() {
		return labelTitle3;
	}



	public void setLabelTitle3(String labelTitle3) {
		this.labelTitle3 = labelTitle3;
	}



	public String getLblNumberToWord() {
		return lblNumberToWord;
	}



	public void setLblNumberToWord(String lblNumberToWord) {
		this.lblNumberToWord = lblNumberToWord;
	}



	public String getCompanySignature() {
		return companySignature;
	}



	public void setCompanySignature(String companySignature) {
		this.companySignature = companySignature;
	}



	public void resetValues(){
		
		 comboBox=null;
		
		 textFieldForHsn=null;
		
		 textFieldForQty.clear();
		
		 textFieldForRate.clear();
		 
		 textFieldForMrp.clear();
		
		 textFieldForValue.clear();
		
		 textFieldTo=null;
		 textAreaAddress=null;
		 textFieldGstin=null;
		
		 textFieldSubTotal=null;
		 textFieldTotalQty=null;
		 textFieldGrandTotal=null;
		
		 textFieldBillNo=null;
		 textFieldDate=null;
		
		 textAreaSpace=null;
		
		 labelTitle1=null;
		 labelTitle2=null;
		 labelTitle3=null;
		 
		 lblNumberToWord=null;
		 
		 companySignature=null;
		
	}

}
