/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.63
 * Generated at: 2016-05-24 16:21:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel='stylesheet' href='webjars/bootstrap/3.0.0/css/bootstrap.css'>\r\n");
      out.write("<script src=\"resources/js/validator.js\"></script>\r\n");
      out.write("<link rel='stylesheet' href='resources/sweetalert-master/dist/sweetalert.css'>\r\n");
      out.write("<script>\r\n");
      out.write("$(window).load(function()\r\n");
      out.write("{\r\n");
      out.write("  \r\n");
      out.write("   $('.hold-widgets').validator().on('submit', function (e) {\r\n");
      out.write("  if (e.isDefaultPrevented()) {\r\n");
      out.write("    // handle the invalid form...\r\n");
      out.write("     changePassword();\r\n");
      out.write("  } else {\r\n");
      out.write("    // everything looks good!\r\n");
      out.write("    alert(\"look good\");\r\n");
      out.write("  }\r\n");
      out.write("}) \r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//call to change password\r\n");
      out.write("var changePassword = function()\r\n");
      out.write("{\r\n");
      out.write("  var http = new XMLHttpRequest();\r\n");
      out.write("  var firstname = document.getElementById(\"firstname\").value;\r\n");
      out.write("  var secondname = document.getElementById(\"secondname\").value;\r\n");
      out.write("  var studentnumber = document.getElementById(\"studentnumber\").value;\r\n");
      out.write("  var course = document.getElementById(\"course\").value;\r\n");
      out.write("  var duration = document.getElementById(\"courseduration\").value;\r\n");
      out.write("  var tuition = document.getElementById(\"tuition\").value;\r\n");
      out.write("\tvar url = \"http://localhost:8080/AutomaticAccessSystem/createStudent?firstname=\"+firstname+\"&secondname=\"+secondname+\"&studentnumber=\"+studentnumber+\"&course=\"+course+\"&duration=\"+duration+\"&tuition=\"+tuition;\r\n");
      out.write("\t\t\r\n");
      out.write("\thttp.open(\"POST\", url, false);\r\n");
      out.write("\t\r\n");
      out.write("\thttp.onreadystatechange = function() {\r\n");
      out.write("\t    var status = http.status;\r\n");
      out.write("\t    if(http.readyState == 4 && http.status == 201) {\r\n");
      out.write("\t       \r\n");
      out.write("\t        swal(\"Success\",\" Student successfully registered\", \"success\");   \r\n");
      out.write("\t    }\r\n");
      out.write("\t    else\r\n");
      out.write("\t    {\r\n");
      out.write("\t          swal(\"Failed\", http.status, \"error\");   \r\n");
      out.write("\t    }\r\n");
      out.write("   }\r\n");
      out.write("  http.send(null);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-div\">\r\n");
      out.write("\r\n");
      out.write("     <div>\r\n");
      out.write("     <p id=\"register-message\">Fill in the details to register student</p>\r\n");
      out.write("     <hr id=\"horizontal-rule\">\r\n");
      out.write("     </div>\r\n");
      out.write("     \r\n");
      out.write(" <div class=\"change-password-container\">\r\n");
      out.write("<form autocomplete=\"off\" class=\"hold-widgets\" role=\"form\" data-toggle=\"validator\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-widgets\">\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"First name\" id=\"firstname\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"Second name\" id=\"secondname\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"Student number\" id=\"studentnumber\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"Course\" id=\"course\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"Course duration\" id=\"courseduration\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"form-group\">\r\n");
      out.write("<input type=\"text\" placeholder=\"Tuition\" id=\"tuition\" class=\"form-control\" required=\"required\"/>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div> <button type=\"submit\" class=\"btn btn-primary\">Submit</button></div>\r\n");
      out.write("</div>\r\n");
      out.write("</form>>\r\n");
      out.write("\t    \r\n");
      out.write("\t </div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
