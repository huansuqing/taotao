package com.taotao.test;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSTest {

	@Test
	public void testUpload() throws IOException, Exception{
//		/**1、加载配置文件，配置文件中的内容就是tracker服务的地址。
//		配置文件内容：tracker_server=192.168.85.130:22122
//		2、创建一个TrackerClient对象。直接new一个。
		//初始化加载配置文件
		ClientGlobal.init("E:/workspaces/item_two/taotao-manager-web/src/main/resources/resource/client.conf");
		
		TrackerClient client = new TrackerClient();
//		3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = client.getConnection();
//		4、创建一个StorageServer的引用，值为null
		StorageServer storageServer=null;
//		5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//		6、使用StorageClient对象上传图片。
		String[] strings = storageClient.upload_file("E:/相册/桌面壁纸/6d81800a19d8bc3e3bad2adf888ba61ea8d34579.jpg", "jpg", null);
//		7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}
		
		
		
	}
	
}
