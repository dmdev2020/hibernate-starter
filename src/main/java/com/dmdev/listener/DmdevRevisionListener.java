package com.dmdev.listener;

import com.dmdev.entity.Revision;
import org.hibernate.envers.RevisionListener;

public class DmdevRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
//        SecurityContext.getUser().getId()
        ((Revision) revisionEntity).setUsername("dmdev");
    }
}
