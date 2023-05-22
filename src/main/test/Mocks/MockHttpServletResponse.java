package Mocks;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class MockHttpServletResponse implements HttpServletResponse {
	 private PrintWriter writer;
	
	  private int status;
      private String contentType;
    
    
      private String characterEncoding;

     

      public int getStatus() {
          return status;
      }

      public String getContentType() {
          return contentType;
      }

      public String getCharacterEncoding() {
          return characterEncoding;
      }

      @Override
      public PrintWriter getWriter() {
          return writer;
      }

      @Override
      public void setStatus(int sc) {
          status = sc;
      }

      @Override
      public void setContentType(String type) {
          contentType = type;
      }

      @Override
      public void setCharacterEncoding(String charset) {
          characterEncoding = charset;
      }
  
      public void setWriter(StringWriter stringWriter) {
          stringWriter = stringWriter;
      }

    
     

     

	

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}	

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDateHeader(String name, long date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHeader(String name, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addIntHeader(String name, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String encodeRedirectURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeRedirectUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encodeUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendError(int sc, String msg) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendRedirect(String location) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDateHeader(String name, long date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHeader(String name, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIntHeader(String name, int value) {
		// TODO Auto-generated method stub

	}



	@Override
	public void setStatus(int sc, String sm) {
		// TODO Auto-generated method stub

	}

	// Implement other methods as needed
}

