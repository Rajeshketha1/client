package com.example.client.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

public class JwtFilter implements Filter {
  private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    String bearerToken = req.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      String jwt = bearerToken.substring(7, bearerToken.length());
      LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
      try {
        Claims claims =
            Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("itsmykeynevertouch"))
                .parseClaimsJws(jwt)
                .getBody();
        LOG.info("get claims subject info {} ::", claims.getSubject());
        chain.doFilter(request, response);
        LOG.info("Logging Response :{}", res.getContentType());
      } catch (Exception e) {
        LOG.error("error");
      }
    }
  }
}
