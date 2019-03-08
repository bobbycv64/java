<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!Information.jsp - cv64, Inc. - http://www.cv64.com>
<html><head><title>cv64, Inc - Information.jsp</title></head>

<body text="#000000" bgcolor="#CCFFFF" link="#0000EE" vlink="#551A8B" alink="#FF0000">
<center><table border=5 align="center">
<tr><th class=title">Information Page</table><br>

<br><br>Java<br><br>

Date: <%= new java.util.Date() %>

<br><br>javax.servlet.ServletRequest<br><br>

Attribute: <%= request.getAttribute("test") %><br>
Attribute Names: <%= request.getAttributeNames() %><br>
Character Encoding: <%= request.getCharacterEncoding() %><br>
Content Length: <%= request.getContentLength() %><br>
Content Type: <%= request.getContentType() %><br>
Input Stream: <%= request.getInputStream() %><br>
Locale: <%= request.getLocale() %><br>
Locales: <%= request.getLocales() %><br>
Parameter: <%= request.getParameter("test") %><br>
Parameter Names: <%= request.getParameterNames() %><br>
Parameter Values: <%= request.getParameterValues("test") %><br>
Protocol: <%= request.getProtocol() %><br>
Reader: <%= request.getReader() %><br>
Remote Address: <%= request.getRemoteAddr() %><br>
Remote Host: <%= request.getRemoteHost() %><br>
Scheme: <%= request.getScheme() %><br>
Server Name: <%= request.getServerName() %><br>
Server Port: <%= request.getServerPort() %><br>
Is Secure: <%= request.isSecure() %>

<br><br>javax.servlet.http.HttpServletRequest<br><br>

Authorization Type: <%= request.getAuthType() %><br>
Context Path: <%= request.getContextPath() %><br>
Header Names: <%= request.getHeaderNames() %><br>
Method: <%= request.getMethod() %><br>
Path Info: <%= request.getPathInfo() %><br>
Path Translated: <%= request.getPathTranslated() %><br>
Query String: <%= request.getQueryString() %><br>
Remote User: <%= request.getRemoteUser() %><br>
Requested Session Id: <%= request.getRequestedSessionId() %><br>
Request URI: <%= request.getRequestURI() %><br>
Servlet Path: <%= request.getServletPath() %><br>
Session: <%= request.getSession() %><br>
User Principal: <%= request.getUserPrincipal() %><br>
RequestedSessionIdFromCookie: <%= request.isRequestedSessionIdFromCookie() %><br>
RequestedSessionIdFromURL: <%= request.isRequestedSessionIdFromURL() %><br>
RequestedSessionIdValid: <%= request.isRequestedSessionIdValid() %>

<br><br>javax.servlet.http.HttpSession<br><br>

Attribute: <%= session.getAttribute("test") %><br>
Attribute Names: <%= session.getAttributeNames() %><br>
Creation Time: <%= session.getCreationTime() %><br>
Session Id: <%= session.getId() %><br>
Max Inactive Interval: <%= session.getMaxInactiveInterval() %><br>
Session Context: <%= session.getSessionContext() %><br>
Value: <%= session.getValue("test") %><br>
Value Names: <%= session.getValueNames() %><br>
Is New: <%= session.isNew() %>

<br><br>javax.servlet.ServletConfig<br><br>

Init Parameter: <%= config.getInitParameter("test") %><br>
Init Parameter Names: <%= config.getInitParameterNames() %><br>
Servlet Context: <%= config.getServletContext() %><br>
Servlet Name: <%= config.getServletName() %>

<br><br>javax.servlet.ServletContext<br><br>

Attribute: <%= config.getServletContext().getAttribute("test") %><br>
Attribute Names: <%= config.getServletContext().getAttributeNames() %><br>
Context: <%= config.getServletContext().getContext("/") %><br>
Init Parameter: <%= config.getServletContext().getInitParameter("test") %><br>
Init Parameter Names: <%= config.getServletContext().getInitParameterNames() %><br>
Major Version: <%= config.getServletContext().getMajorVersion() %><br>
Minor Version: <%= config.getServletContext().getMinorVersion() %><br>
Real Path: <%= config.getServletContext().getRealPath("/") %><br>
Server Info: <%= config.getServletContext().getServerInfo() %><br>
</body></html>
