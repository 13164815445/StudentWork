import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class Test {
	public static Logger logger=Logger.getLogger("http:");
	private static CloseableHttpClient httpClient=HttpClients.createDefault();
	private static HttpClientContext context=new HttpClientContext();
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("��ʼ��½---");
		Http http=new Http();
		CloseableHttpResponse response=http.Login();

		Header[] header=response.getHeaders("set-cookie");
		String cookie=new String(header[0].getValue()).split(";")[0];	
		Header[] headers=response.getHeaders("Location");
		
	String content=null;
	try{
		//��һ�ο�ʼ�ض���--------------------------
		HttpPost post=new HttpPost(headers[0].getValue());
		post.addHeader("Referer", "http://jwch.fzu.edu.cn/");
		post.addHeader("Connection","keep-alive");
		
		CloseableHttpResponse response1=httpClient.execute(post,context);
		System.out.println(response1.getStatusLine());
		logger.info("��ȡ����ͷheader");
		Header[] headers3=response1.getAllHeaders();
		/*for(int i=0;i<headers3.length;i++){
			System.out.println(headers3[i].getName()+":"+headers3[i].getValue());
		}*/
		Header[] cookies=response1.getHeaders("set-cookie");	
		
		//ץȡsessionid
		String first=response1.getHeaders("Location")[0].getValue().split("=")[1];
		String id=first.split("&")[0];
		logger.info(id);
		HttpEntity entity=response1.getEntity();
		content=EntityUtils.toString(entity);
		//System.out.println(content+"\n"+response1.getHeaders("Location")[0].getValue());
		
		//�ڶ����ض���
		post=new HttpPost(response1.getHeaders("Location")[0].getValue());
		post.addHeader("Connection","keep-alive");



		response=httpClient.execute(post,context);
		entity=response.getEntity();
		content=EntityUtils.toString(entity);
		//System.out.println(content);
		
		//��ȡ�α���Ϣ
		 post=new HttpPost("http://59.77.226.35/student/xkjg/wdkb/kb_xs.aspx"+"?id="+id);

		 response=httpClient.execute(post,context);
		 logger.info(response.getStatusLine().toString());
		 entity=response.getEntity();
		 content=EntityUtils.toString(entity);
	//	 System.out.println(content);
		 
		 //ץȡ�α���Ϣ
		 Document document=Jsoup.parse(content);
		 Element element=document.getElementById("ContentPlaceHolder1_LB_kb");
		 Elements es=element.getElementsByTag("tr");
		 
		 HashMap<String,Course> kb = new HashMap<String,Course>();//���ݿγ������浽hasmap
		 for(int m=1;m<es.size();m=m+2){
		 String[] strings=new String(es.get(m).text()).split(" ");
		 if(strings[0].equals("����")||strings[0].equals("����")||strings[0].equals("����")){//��һ������ʱ���ʱ�������Ŀα������ڵ������ų���
			 Course course=new Course();
		 for(int i=3,a=1;i<strings.length;i++,a++){
			 
			// System.out.print(strings[i]+"    ");
			 if(a%5==0){		//��Ϊ���ڽ����Լ��ڿμƻ��ȵȣ���ǰ����ֻ����γ����ƺͽ�ʦ������ÿ��1  4����Ϊһ���γ̶���
				kb.put(course.getCourseName(),course);
				 course=new Course();
				 //System.out.println();
			 }
			 if(a%5==1){
				 course.setCourseName(strings[i]);
				// System.out.println(strings[i]);
			 }
			 if(a%5==4){
				 course.setCourseTeacher(strings[i]);
				// System.out.println(strings[i]);
			 }
			 
			 
		 	}
		 }else{
			 Course course=new Course();
			 for(int i=2,a=1;i<strings.length;i++,a++){
				 
				// System.out.print(strings[i]+"    ");
				 if(a%5==0){
					 kb.put(course.getCourseName(),course);
					 course=new Course();
					// System.out.println();
				 }
				 if(a%5==1){
					 course.setCourseName(strings[i]);
					// System.out.println(strings[i]);
				 }
				 if(a%5==4){
					 course.setCourseTeacher(strings[i]);
					 //System.out.println(strings[i]);
				 }
				 
				 
			 	}
		 }
		 }
		/* Elements elements=document.getElementsByTag("Font");
		 for (Element font : elements) {
			  System.out.println(font.text());
			}*/
		 
		 logger.info("���ץȡ�Ŀγ���Ϣ");
		 for(Course course:kb.values()){
			 System.out.println(course.getCourseName()+"    "+course.getCourseTeacher());
		 }
		 
		 
		 Ftp t = new Ftp();      
         
         boolean connecting = t.connect("", "211.80.196.1", 21, "download", "download");      
        System.out.println( "���� ��" + connecting  );  
      //  t.download("",kb , "C:\\Users\\huangwei\\Desktop");
	}catch(Exception e){
		e.printStackTrace();
		if(response!=null){
			try {
				response.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
	}
}