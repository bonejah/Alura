/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.11
 * Generated at: 2018-08-06 16:13:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class template_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-5.0.2.RELEASE.jar", Long.valueOf(1512609936000L));
    _jspx_dependants.put("jar:file:/C:/Users/bplima/Documents/Desenvolvimento/GitHub/ProjetosAlura/Javascript/BlockChain/target/tomcat.8080/webapps/expanded/WEB-INF/lib/spring-security-taglibs-5.0.0.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1511820172000L));
    _jspx_dependants.put("jar:file:/C:/Users/bplima/Documents/Desenvolvimento/GitHub/ProjetosAlura/Javascript/BlockChain/target/tomcat.8080/webapps/expanded/WEB-INF/lib/jstl-impl-1.2.jar!/META-INF/c.tld", Long.valueOf(1308137770000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl-1.2.jar", Long.valueOf(1418162796000L));
    _jspx_dependants.put("jar:file:/C:/Users/bplima/Documents/Desenvolvimento/GitHub/ProjetosAlura/Javascript/BlockChain/target/tomcat.8080/webapps/expanded/WEB-INF/lib/spring-webmvc-5.0.2.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1511785628000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-5.0.0.RELEASE.jar", Long.valueOf(1512610758000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.servlet.jsp.JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public void setJspContext(javax.servlet.jsp.JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(this, ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public javax.servlet.jsp.JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String titulo;

  public java.lang.String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(java.lang.String titulo) {
    this.titulo = titulo;
    jspContext.setAttribute("titulo", titulo);
  }

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    return _jsp_instancemanager;
  }

  private void _jspInit(javax.servlet.ServletConfig config) {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(config);
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(config);
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.release();
  }

  public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
    javax.servlet.jsp.PageContext _jspx_page_context = (javax.servlet.jsp.PageContext)jspContext;
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest) _jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse) _jspx_page_context.getResponse();
    javax.servlet.http.HttpSession session = _jspx_page_context.getSession();
    javax.servlet.ServletContext application = _jspx_page_context.getServletContext();
    javax.servlet.ServletConfig config = _jspx_page_context.getServletConfig();
    javax.servlet.jsp.JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,jspContext);
    if( getTitulo() != null ) 
      _jspx_page_context.setAttribute("titulo", getTitulo());

    try {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <title>Login</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"/assets/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"/assets/css/style.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Menu -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">Electio</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarColor01\">\n");
      out.write("            <ul class=\"navbar-nav mr-auto\">\n");
      out.write("            \t");
      if (_jspx_meth_sec_005fauthorize_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t             \n");
      out.write("\t            ");
      if (_jspx_meth_sec_005fauthorize_005f1(_jspx_page_context))
        return;
      out.write("\t                                             \n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"/voters/form\">Novo eleitor</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"/votingbooth/code/form\">Gerar número de participação</a>\n");
      out.write("                </li>                                \n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"/votingbooth/choose/ellection/form\">Votar</a>\n");
      out.write("                </li>                                \n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <!-- ./Menu -->\n");
      out.write("\n");
      out.write("    <!-- Cabecalho -->\n");
      out.write("    <div class=\"jumbotron\">\n");
      out.write("        <h1 class=\"text-center\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${titulo}", java.lang.String.class, (javax.servlet.jsp.PageContext)this.getJspContext(), null));
      out.write("\n");
      out.write("        </h1>\n");
      out.write("    </div>\n");
      out.write("    <!-- ./Cabecalho -->\n");
      out.write("    \n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t");
      ((org.apache.jasper.runtime.JspContextWrapper) this.jspContext).syncBeforeInvoke();
      _jspx_sout = null;
      if (getJspBody() != null)
        getJspBody().invoke(_jspx_sout);
      jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,getJspContext());
      out.write("\n");
      out.write("\t</div>    \n");
      out.write("\t\n");
      out.write("    <script src=\"/assets/js/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"/assets/js/popper.min.js\"></script>\n");
      out.write("    <script src=\"/assets/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\t\n");
    } catch( java.lang.Throwable t ) {
      if( t instanceof javax.servlet.jsp.SkipPageException )
          throw (javax.servlet.jsp.SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof java.lang.IllegalStateException )
          throw (java.lang.IllegalStateException) t;
      if( t instanceof javax.servlet.jsp.JspException )
          throw (javax.servlet.jsp.JspException) t;
      throw new javax.servlet.jsp.JspException(t);
    } finally {
      jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
      _jspDestroy();
    }
  }

  private boolean _jspx_meth_sec_005fauthorize_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f0 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f0_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f0.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f0.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));      // /WEB-INF/tags/template.tag(28,13) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f0.setAccess("isAuthenticated()");
      int _jspx_eval_sec_005fauthorize_005f0 = _jspx_th_sec_005fauthorize_005f0.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t                <li class=\"nav-item active\">\n");
        out.write("\t                    <a class=\"nav-link\" href=\"/logout\">Sair</a>\n");
        out.write("\t                </li>\n");
        out.write("\t                <li class=\"nav-item active\">\n");
        out.write("\t                    <a class=\"nav-link\" href=\"/ellections/form\">Nova eleição</a>\n");
        out.write("\t                </li>                \n");
        out.write("\t                <li class=\"nav-item active\">\n");
        out.write("\t                    <a class=\"nav-link\" href=\"/candidates/form\">Cadastro de candidatos</a>\n");
        out.write("\t                </li>                \n");
        out.write("\t                <li class=\"nav-item active\">\n");
        out.write("\t                    <a class=\"nav-link\" href=\"/registered\">Liberação de eleitores</a>\n");
        out.write("\t                </li>\n");
        out.write("\t             ");
      }
      if (_jspx_th_sec_005fauthorize_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        throw new javax.servlet.jsp.SkipPageException();
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f0);
      _jspx_th_sec_005fauthorize_005f0_reused = true;
    } finally {
      if (!_jspx_th_sec_005fauthorize_005f0_reused) {
        _jspx_th_sec_005fauthorize_005f0.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_sec_005fauthorize_005f0);
      }
    }
    return false;
  }

  private boolean _jspx_meth_sec_005fauthorize_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sec:authorize
    org.springframework.security.taglibs.authz.JspAuthorizeTag _jspx_th_sec_005fauthorize_005f1 = (org.springframework.security.taglibs.authz.JspAuthorizeTag) _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.get(org.springframework.security.taglibs.authz.JspAuthorizeTag.class);
    boolean _jspx_th_sec_005fauthorize_005f1_reused = false;
    try {
      _jspx_th_sec_005fauthorize_005f1.setPageContext(_jspx_page_context);
      _jspx_th_sec_005fauthorize_005f1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) this ));      // /WEB-INF/tags/template.tag(43,13) name = access type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_sec_005fauthorize_005f1.setAccess("not isAuthenticated()");
      int _jspx_eval_sec_005fauthorize_005f1 = _jspx_th_sec_005fauthorize_005f1.doStartTag();
      if (_jspx_eval_sec_005fauthorize_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\n");
        out.write("\t                <li class=\"nav-item active\">\n");
        out.write("\t                    <a class=\"nav-link\" href=\"/login\">Login</a>\n");
        out.write("\t                </li>\n");
        out.write("\t            ");
      }
      if (_jspx_th_sec_005fauthorize_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        throw new javax.servlet.jsp.SkipPageException();
      }
      _005fjspx_005ftagPool_005fsec_005fauthorize_0026_005faccess.reuse(_jspx_th_sec_005fauthorize_005f1);
      _jspx_th_sec_005fauthorize_005f1_reused = true;
    } finally {
      if (!_jspx_th_sec_005fauthorize_005f1_reused) {
        _jspx_th_sec_005fauthorize_005f1.release();
        _jsp_getInstanceManager().destroyInstance(_jspx_th_sec_005fauthorize_005f1);
      }
    }
    return false;
  }
}