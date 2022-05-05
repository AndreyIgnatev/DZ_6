package ru.gb.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebConfig implements WebApplicationInitializer {

    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    // ServletContext servletContext - это большой контейнер томкат, где живут севлеты.
    // AnnotationConfigWebApplicationContext context - сюда кидаем контекст со всеми бинами, согласно конфигурации.

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext(); // вэб создаем контекст
        context.register(HelloConfiguration.class); // регистрируем нашу конфигурацию
        // Создаем наш дистпечер сервлет и кладем в него наш контекст со всеми бинами
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        // Регистрируем наш созданный сервлет в контейненере серлетов Томкат
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1); // Указываем приоритизацию.
        registration.addMapping("/");
        // Прописываем, что наш диспетчер ловит все корневые запросы, то есть, корнем считается url: localhost:8080/spring/
        // Важно на заметку, томкат по умолчанию настроен смотреть в папку webapp и искать там страницу index.html
        // spring в url - это название финальной war сборки в pom файле.

    }
}
