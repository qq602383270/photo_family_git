package cn.pothofamily.chat.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import cn.pothofamily.chat.entity.Message;
import cn.pothofamily.chat.event.ChatMessageEvent;

@Service
public class ChatService
  implements ApplicationContextAware
{
  private ApplicationContext ctx;
  
  public void setApplicationContext(ApplicationContext ctx)
    throws BeansException
  {
    this.ctx = ctx;
  }
  
  public void sendMessage(Message msg)
  {
    this.ctx.publishEvent(new ChatMessageEvent(msg));
  }
}
