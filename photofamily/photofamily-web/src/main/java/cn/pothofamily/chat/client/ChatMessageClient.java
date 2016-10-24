package cn.pothofamily.chat.client;

import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import cn.photofamily.core.commons.utils.DateUtils;
import cn.pothofamily.chat.entity.Message;
import cn.pothofamily.chat.event.ChatMessageEvent;

@SuppressWarnings("rawtypes")
@Component
public class ChatMessageClient implements ApplicationListener, ServletContextAware {
    @SuppressWarnings("unused")
    private ServletContext ctx;

    public void setServletContext(ServletContext ctx) {
        this.ctx = ctx;
    }

    public void onApplicationEvent(ApplicationEvent event) {
        if ((event instanceof ChatMessageEvent)) {
            Message msg = (Message) event.getSource();
            ServerContext context = ServerContextFactory.get();

            Collection<ScriptSession> sessions = context.getAllScriptSessions();
            for (ScriptSession session : sessions) {
                ScriptBuffer sb = new ScriptBuffer();
                Date time = msg.getTime();
                String s = DateUtils.formatDate(time, "yyyy-MM-dd HH:mm:ss");

                sb.appendScript("showMessage({msg: '").appendScript(msg.getMsg()).appendScript("', time: '").appendScript(s).appendScript("'})");
                System.out.println(sb.toString());

                session.addScript(sb);
            }
        }
    }
}


