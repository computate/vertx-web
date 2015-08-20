package io.vertx.ext.web.impl;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.*;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.security.cert.X509Certificate;

class HttpServerRequestWrapper implements HttpServerRequest {

  private final HttpServerRequest delegate;
  private HttpMethod method;
  private String path;

  HttpServerRequestWrapper(HttpServerRequest request) {
    delegate = request;
    method = request.method();
    path = request.path();
  }

  @Override
  public HttpServerRequest exceptionHandler(Handler<Throwable> handler) {
    return delegate.exceptionHandler(handler);
  }

  @Override
  public HttpServerRequest handler(Handler<Buffer> handler) {
    return delegate.handler(handler);
  }

  @Override
  public HttpServerRequest pause() {
    return delegate.pause();
  }

  @Override
  public HttpServerRequest resume() {
    return delegate.resume();
  }

  @Override
  public HttpServerRequest endHandler(Handler<Void> handler) {
    return delegate.endHandler(handler);
  }

  @Override
  public HttpVersion version() {
    return delegate.version();
  }

  HttpServerRequest setMethod(HttpMethod method) {
    this.method = method;
    return this;
  }

  @Override
  public HttpMethod method() {
    return method;
  }

  @Override
  public String uri() {
    return delegate.uri();
  }

  void setPath(String path) {
    this.path = path;
  }

  @Override
  public String path() {
    return path;
  }

  @Override
  public String query() {
    return delegate.query();
  }

  @Override
  public HttpServerResponse response() {
    return delegate.response();
  }

  @Override
  public MultiMap headers() {
    return delegate.headers();
  }

  @Override
  public String getHeader(String s) {
    return delegate.getHeader(s);
  }

  @Override
  public String getHeader(CharSequence charSequence) {
    return delegate.getHeader(charSequence);
  }

  @Override
  public MultiMap params() {
    return delegate.params();
  }

  @Override
  public String getParam(String s) {
    return delegate.getParam(s);
  }

  @Override
  public SocketAddress remoteAddress() {
    return delegate.remoteAddress();
  }

  @Override
  public SocketAddress localAddress() {
    return delegate.localAddress();
  }

  @Override
  public X509Certificate[] peerCertificateChain() throws SSLPeerUnverifiedException {
    return delegate.peerCertificateChain();
  }

  @Override
  public String absoluteURI() {
    return delegate.absoluteURI();
  }

  @Override
  public HttpServerRequest bodyHandler(Handler<Buffer> handler) {
    return delegate.bodyHandler(handler);
  }

  @Override
  public NetSocket netSocket() {
    return delegate.netSocket();
  }

  @Override
  public HttpServerRequest setExpectMultipart(boolean b) {
    return delegate.setExpectMultipart(b);
  }

  @Override
  public boolean isExpectMultipart() {
    return delegate.isExpectMultipart();
  }

  @Override
  public HttpServerRequest uploadHandler(Handler<HttpServerFileUpload> handler) {
    return delegate.uploadHandler(handler);
  }

  @Override
  public MultiMap formAttributes() {
    return delegate.formAttributes();
  }

  @Override
  public String getFormAttribute(String s) {
    return delegate.getFormAttribute(s);
  }

  @Override
  public ServerWebSocket upgrade() {
    return delegate.upgrade();
  }

  @Override
  public boolean isEnded() {
    return delegate.isEnded();
  }
}
