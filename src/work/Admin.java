package work;

import common.Utils;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hhy on 2017/6/2.
 */
@WebServlet(name = "Admin", urlPatterns = {"/am"})
public class Admin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/plain;charset=UTF-8;pageEncoding=UTF-8");
        String result = "Matrix";
        /* mission detail */
        result = Utils.get_JSON();
        /* end */
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
