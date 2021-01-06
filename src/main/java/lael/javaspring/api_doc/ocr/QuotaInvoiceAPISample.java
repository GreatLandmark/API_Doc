package lael.javaspring.api_doc.ocr;

import java.net.URLEncoder;
import com.alibaba.fastjson.JSON;

import lael.javaspring.api_doc.baidu.AuthService;
import lael.javaspring.api_doc.beans.QuotaInvoiceBean;
import lael.javaspring.api_doc.utils.Base64Util;
import lael.javaspring.api_doc.utils.FileUtil;
import lael.javaspring.api_doc.utils.HttpUtil;
/**
 * 定额发票API示例代码
 * @author 小帅丶
 *
 */
public class QuotaInvoiceAPISample {
	//接口地址
	public static String QUOTAINVOICE_URL = "https://aip.baidubce.com/rest/2.0/ocr/v1/quota_invoice";
	//根据应用APIKEY SECRETKEY 获取的accesstoken 文档 https://ai.baidu.com/docs#/Auth/75d80ed1
	public static String ACCESSTOKEN = "";
	
	public static void main(String[] args) {
		ACCESSTOKEN=AuthService.getAuth();
		// System.out.println("Token:"+ACCESSTOKEN);
		//返回字符串
//		String result=getQuotaInvoiceText("G:/testimg/QuotaInvoice.jpg");
		//返回bean对象 方便取值
		QuotaInvoiceBean bean = getQuotaInvoiceBean("resources/pictures/quota_invoice1.jpg");
		System.out.println("发票代码==>"+bean.getWords_result().getInvoice_code());
		System.out.println("发票号码==>"+bean.getWords_result().getInvoice_number());
		System.out.println("发票金额==>"+bean.getWords_result().getInvoice_rate());
	}
		
	/**
	 * 定额发票识别 通过图片获取手写文字内容
	 * 返回字符串
	 * @param filePath 图片文件目录
	 * @return text
	 */
	public  static String getQuotaInvoiceText(String filePath){
		String result = "";
		 try {
	            byte[] imgData = FileUtil.readFileByBytes(filePath);
	            String imgStr = Base64Util.encode(imgData);
	           //识别图片上的手写文字
	            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
	            result = HttpUtil.post(QUOTAINVOICE_URL, ACCESSTOKEN, params);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return result;
	}
	/**
	 * 定额发票识别 通过图片获取手写文字内容
	 * 返回对象
	 * @param filePath 图片文件目录
	 * @return QuotaInvoiceBean
	 */
	public static QuotaInvoiceBean getQuotaInvoiceBean(String filePath){
		String result = getQuotaInvoiceText(filePath);
		QuotaInvoiceBean bean = JSON.parseObject(result,QuotaInvoiceBean.class);
		return bean;
	}
}