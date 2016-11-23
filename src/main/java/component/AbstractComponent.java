/**
 * @author SYESILDAG
 */
package component;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractComponent<D extends Data, T extends Data, C extends AbstractComponent<? extends T, ?, ?>> implements Component<D, T, C>
{
   private String key;
   private String className;
   private Component.NameSpace nameSpace;
   private D data;
   private List<? extends C> components;
   
   public AbstractComponent(){
   }
   
   public AbstractComponent(String key, Component.NameSpace nameSpace, D data, List<? extends C> components)
   {
      this.key = key;
      this.nameSpace = nameSpace;
      this.data = data;
      this.components = components;
   }
   
   /* (non-Javadoc)
    * @see component.Component#getHTML()
    */
   @JsonIgnore
   @Override
   public String getHTML()
   {
      return "<"+this.getTag()+" "+getDataKeySelector(this.getKey())+" data-jreact-namespace='" + this.getNameSpace().name() + "' data-jreact-name='" + this.getName() + "'></"+this.getTag()+">";
   }
   
   /* (non-Javadoc)
    * @see component.Component#getKey()
    */
   @JsonProperty
   @Override
   public final String getKey()
   {
      return this.key;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setKey(java.lang.String)
    */
   @JsonIgnore
   @Override
   public final void setKey(String name)
   {
      // NOT SET
   }
   
   /* (non-Javadoc)
    * @see component.Component#getClassName()
    */
   @JsonProperty
   @Override
   public String getClassName()
   {
      return this.className;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setClassName(java.lang.String)
    */
   @JsonIgnore
   @Override
   public final void setClassName(String className)
   {
      this.className = className;
   }
   
   /* (non-Javadoc)
    * @see component.Component#getTag()
    */
   @JsonProperty
   @Override
   public abstract component.Component.Tag getTag();
   
   /* (non-Javadoc)
    * @see component.Component#setTag(component.Component.Tag)
    */
   @JsonIgnore
   @Override
   public final void setTag(Tag tag)
   {
      // NOT SET
   }
   
   /* (non-Javadoc)
    * @see component.Component#getName()
    */
   @JsonProperty
   @Override
   public final String getName()
   {
      return this.getClass().getSimpleName();
   }
   
   /* (non-Javadoc)
    * @see component.Component#setName(java.lang.String)
    */
   @JsonIgnore
   @Override
   public final void setName(String name)
   {
      // NOT SET
   }
   
   /* (non-Javadoc)
    * @see component.Component#getNameSpace()
    */
   @Override
   public final Component.NameSpace getNameSpace()
   {
      return this.nameSpace;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setNameSpace(component.Component.NameSpace)
    */
   @Override
   public final void setNameSpace(Component.NameSpace nameSpace)
   {
      this.nameSpace = nameSpace;
   }
   
   /* (non-Javadoc)
    * @see component.Component#getTemplateID()
    */
   @JsonProperty
   @Override
   public final String getTemplateID()
   {
      return this.getClass().getName();
   }
   
   /* (non-Javadoc)
    * @see component.Component#setTemplateID(java.lang.String)
    */
   @JsonIgnore
   @Override
   public final void setTemplateID(String templateID)
   {
      // NOT SET
   }
   
   /* (non-Javadoc)
    * @see component.Component#getTemplateHTML()
    */
   @JsonIgnore
   @Override
   public String getTemplateHTML()
   {
      return null;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setTemplateHTML(java.lang.String)
    */
   @JsonIgnore
   @Override
   public void setTemplateHTML(String templateHTML)
   {
      // NOT SET
   }
   
   /* (non-Javadoc)
    * @see component.Component#getData()
    */
   @Override
   public final D getData()
   {
      return this.data;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setData(com.resalys.engine.web.component.Data)
    */
   @Override
   public final void setData(D data)
   {
      this.data = data;
   }
   
   /* (non-Javadoc)
    * @see component.Component#getComponents()
    */
   @Override
   public final List<? extends C> getComponents()
   {
      return this.components;
   }
   
   /* (non-Javadoc)
    * @see component.Component#setComponents(java.util.List)
    */
   @Override
   public final void setComponents(List<? extends C> components)
   {
      this.components = components;
   }
   
   @JsonIgnore
   public String getJReactInstance() {
      return "JReact.getInstance("+this.getJQueryInstance()+")";
   }
   
   @JsonIgnore
   public String getJQueryInstance() {
      return "jQuery('"+this.getTag()+"["+getDataKeySelector(this.getKey())+"]')";
   }
   
   private static String getDataKeySelector(String selector)
   {
      return "data-key="+selector;
   }
}