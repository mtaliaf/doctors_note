package com.doctorsnote.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import com.google.common.net.MediaType;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

public class ResponseWriter {

  private final HttpServletResponse response;

  @Inject
  ResponseWriter(HttpServletResponse response) {
    this.response = response;
  }

  public void write(MediaType mediaType, Message message) throws IOException {
    response.setContentType(mediaType.toString());
    PrintWriter out = response.getWriter();
    out.println(JsonFormat.printer().print(message));
    out.close();
  }
}
