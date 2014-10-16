package com.frontarts.xml.xstream.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA. @7/31/12 3:37 PM
 * Author: Administrator
 * Copyright © 1994-2011. EMC Corporation. All Rights Reserved.
 */
public class RestListConverter extends AbstractCollectionConverter {

    public RestListConverter(Mapper mapper) {
        super(mapper);
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
          Collection collection = (Collection) source;
          for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
              Object item = iterator.next();
              writeItem(item, context, writer);
          }
      }

      public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
          Collection collection = (Collection) createCollection(context.getRequiredType());
          populateCollection(reader, context, collection);
          return collection;
      }


    @Override
     public boolean canConvert(Class type) {
         return type.equals(ArrayList.class) || type.equals(LinkedList.class);
     }

    @Override
    protected void writeItem(Object item, MarshallingContext context, HierarchicalStreamWriter writer) {
          // PUBLISHED API METHOD! If changing signature, ensure backwards compatibility.
        if (item == null) {
            String name = mapper().serializedClass(null);
            ExtendedHierarchicalStreamWriterHelper.startNode(writer, name, Mapper.Null.class);
            writer.endNode();
        } else {
//            String name = mapper().serializedClass(item.getClass());
//            ExtendedHierarchicalStreamWriterHelper.startNode(writer, name, item.getClass());
            context.convertAnother(item);
//            writer.endNode();
        }
    }

    @Override
    protected Object readItem(HierarchicalStreamReader reader, UnmarshallingContext context, Object current) {
        return super.readItem(reader, context, current);
    }

    protected void populateCollection(HierarchicalStreamReader reader, UnmarshallingContext context, Collection collection) {
        populateCollection(reader, context, collection, collection);
    }

    protected void populateCollection(HierarchicalStreamReader reader, UnmarshallingContext context, Collection collection, Collection target) {
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            addCurrentElementToCollection(reader, context, collection, target);
            reader.moveUp();
        }
    }

    protected void addCurrentElementToCollection(HierarchicalStreamReader reader, UnmarshallingContext context,
          Collection collection, Collection target) {
          Object item = readItem(reader, context, collection);
          target.add(item);
      }

}
