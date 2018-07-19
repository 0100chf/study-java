package com.ks0100_1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Sender extends Thread {
	private PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOutputStream() {
		return out;
	}

	public void run() {
		String s = new String("hi，receiver，请说话。 ");
		try {
			out.write(s.getBytes());//2.Sender 通过管道流PipedOutputStream输出数据
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Receiver extends Thread {
	private PipedInputStream in = new PipedInputStream();

	public PipedInputStream getInputStream() {
		return in;
	}

	public void run() {
		String s = null;
		byte[] buf = new byte[1024];
		int len;
		try {
			len = in.read(buf);
			s = new String(buf, 0, len);
			System.out.println("这是 Sender 发过来的消息: " + s);//3.Receiver通过管道流PipedInputStream，读取另外一个线程的数据。

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
 * 用debug模式，更容易看到程序运行顺序。
 * 在sender和receiver的run()方法上，打断点
 */
public class PipeStreamTest {

	public static void main(String[] args) {
		Sender sender = new Sender();
		Receiver receiver = new Receiver();
		PipedOutputStream out = sender.getOutputStream();
		PipedInputStream in=receiver.getInputStream();
		try {
			out.connect(in);//1.管道流连接
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
