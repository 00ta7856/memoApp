package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//表示：DBからメモ一覧を受け取りJSPに渡す処理
		
		//DBから情報を持ってくる
		//持ってきた情報をBeansに保存
		//JSPに推移
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//新規：新規作成したメモ内容をデータベースに保存する処理
				
		//編集：渡されたIDの内容を渡された情報に書き換える処理
			
		//消去：渡されたIDの情報をDBから消去する処理
	}

}
