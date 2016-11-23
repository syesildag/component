/**
 * @author SYESILDAG
 */
package component;

import java.util.List;

public interface Component<D extends Data, T extends Data, C extends Component<? extends T, ?, ?>>
{
   public static enum NameSpace
   {
      JReactComponents
   }
   
   public static enum Tag
   {
      table, tbody, thead, tr, td
   }
   
   public String getHTML();
   
   public String getKey();
   
   public void setKey(String key);
   
   public String getClassName();
   
   public void setClassName(String className);
   
   public Tag getTag();
   
   public void setTag(Tag tag);
   
   public String getName();
   
   public void setName(String name);
   
   public NameSpace getNameSpace();
   
   public void setNameSpace(NameSpace namespace);
   
   public String getTemplateID();
   
   public void setTemplateID(String templateID);
   
   public String getTemplateHTML();
   
   public void setTemplateHTML(String templateHTML);
   
   public D getData();
   
   public void setData(D data);
   
   public List<? extends C> getComponents();
   
   public void setComponents(List<? extends C> children);
}