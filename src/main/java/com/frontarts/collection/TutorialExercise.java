package com.frontarts.collection;

import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by IntelliJ IDEA. @5/6/14 9:41 AM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class TutorialExercise {

    public <E> Set<E> removeDumps(Collection<E> c) {
        return new LinkedHashSet<E>(c);
    }

    public void FindDuplicates(String ss[]) {

        Set<String> unique = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();
        for (String s : ss) {
            if (!unique.add(s)) {
                duplicates.add(s);
            }
        }
        // if you want to remove the duplicate items
        unique.removeAll(duplicates);

        System.out.println("Unique words:" + unique);
    }

    public <E> Set<E> symmetricDiff(Set<E> a, Set<E> b) {

        Set<E> symmetricDiff = new HashSet<E>(a);
        symmetricDiff.addAll(b);

        Set<E> retain = new HashSet<E>(a);
        retain.retainAll(b);

        symmetricDiff.removeAll(retain);

        return symmetricDiff;
    }

    /*======================================================================*/

    public <E> void swap(List<E> list, int i, int j) {

        E tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public <E> void shuffle(List<E> list) {

        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, i, random.nextInt(i));
        }
    }

    public <E> void shuffleC(List<E> list) {
        Collections.shuffle(list, new Random());
    }

    public <E> void replace(List<E> list, E val, E newVal) {

        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ) {
            if (val == null ? it.next() == null : it.next().equals(val)) {
                it.set(newVal);
            }

        }
    }

    public <E> List<E> dealHand(List<E> deck, int n) {

        List<E> handView = deck.subList(deck.size() - n, deck.size());
        List<E> hand = new ArrayList<E>(handView);

        handView.clear();
        return hand;
    }

    /*=====================================================================================*/
    public void frequency(String[] ss) {

        Map<String, Integer> frequency = new HashMap<String, Integer>();
        for (String s : ss) {
            Integer freq = frequency.get(s);
            frequency.put(s, (freq == null) ? 1 : freq + 1);
        }
    }

    public <K, V> void newAttributes(Map<K, V> defaults, Map<K, V> overrides) {

        Map<K, V> result = new HashMap<K, V>(defaults);
        result.putAll(overrides);
    }

    public <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttr, Set<K> permittedAttr) {

        boolean valid = true;
        Set<K> keySet = attrMap.keySet();

        // check the required attributes
        if (!keySet.containsAll(requiredAttr)) {
            Set<K> missing = new HashSet<K>(requiredAttr);
            missing.removeAll(keySet);
            System.out.println("Missing attributes: " + missing);
            valid = false;
        }

        // check the permitted attributes
        if (!permittedAttr.containsAll(keySet)) {
            Set<K> illegal = new HashSet<K>(keySet);
            illegal.removeAll(permittedAttr);
            System.out.println("illegal attributes: " + illegal);

        }

        return valid;

    }

    public void mixMap(){
        // employee-->manager mapping
        // 1. individual contributors
        Map<String,String> map  = new HashMap<String, String>();
        Set<String> keys = new HashSet<String>(map.keySet());
        keys.removeAll(map.values());

        // 2 remove all employees report to simon
        map.values().removeAll(Collections.singleton("Simon"));

        // 2 find the slackers
        Map<String, String> tmp = new HashMap<String, String>(map);
        map.values().removeAll(tmp.keySet());



    }

    /* =============================== Object Ordering =======================================*/



    @Test
    public void testRemoveCyclic(){
        List shit = new ArrayList();
        shit.add(1);
        shit.add(1);
        shit.add(1);
        shit.add(1);
        shit.removeAll(shit);


        System.out.println(shit.size());

    }



}
