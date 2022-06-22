package com.nagarro.AdvanceJavaAssignment1.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.nagarro.AdvanceJavaAssignment1.input.FolderReader;
import com.nagarro.AdvanceJavaAssignment1.model.Constants;


public class ModificationWatcher implements Runnable, Constants {

    HashMap<String, Long> lastModifiedAt = new HashMap<>();

    public void run() {
        File[] files = file.listFiles();
        ArrayList<String> l = new ArrayList<>();
        for (File f : files) {
            if ((!(lastModifiedAt.containsKey(f.getName()))) || (f.lastModified() > lastModifiedAt.get(f.getName()))) {
                lastModifiedAt.put(f.getName(), f.lastModified());
                synchronized (Utility.tshirtsInfo) {
                    Utility.tshirtsInfo.put(f.getName(), FolderReader.readFile(f));
                }
            }
            l.add(f.getName());
        }

        Set<String> fc = lastModifiedAt.keySet();
        Set<String> tshirtName = new HashSet<>(fc);

        if (fc.size() == l.size())
            return;
        for (String string : tshirtName) {
            if (!(l.contains(string))) {
                lastModifiedAt.remove(string);
                synchronized (Utility.tshirtsInfo) {
                    Utility.tshirtsInfo.remove(string);
                }
            }
        }
    }
}
