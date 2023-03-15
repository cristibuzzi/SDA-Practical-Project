package com.sda.practicalproject.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager{
    private final static SessionManager INSTANCE = new SessionManager();
    private SessionManager(){

    }
    public static SessionFactory getSessionFactory()
    {
        return INSTANCE.getSessionFactory("pet_clinic");
    }

    public static void shutdown()
    {
        INSTANCE.shutdownSessionManager();
    }
    @Override
    protected void setAnnotatedClasses(Configuration configuration) {

    }
}
