/**
 * @author SYESILDAG
 * https://github.com/syesildag/component
 */
package component;

import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ComponentManager<C extends AbstractRootComponent<?, ?, ?>>
{
   private C component;
   
   public ComponentManager()
   {
   }
   
   public ComponentManager(C component)
   {
      this.component = component;
   }
   
   public C getComponent()
   {
      return this.component;
   }
   
   @SuppressWarnings("static-method")
   protected String getBootstrapJS()
   {
      return "JReact.bootstrap(document);";
   }
   
   protected String getRenderJS() throws JsonProcessingException
   {
      C com = this.getComponent();
      return "JReact.render(JReact.createElement("+com.getNameSpace()+"."+com.getName()+", "+this.toJSON()+"), "+com.getJQueryInstance()+".parent());";
   }
   
   protected StringBuilder getScripts()
   {
      StringBuilder scripts = new StringBuilder();
      
      LinkedHashMap<String, String> templates = this.processTemplates();
      for(String templateID : templates.keySet())
      {
         scripts.append("<script type=\"text/html\" id=\""+templateID+"\">");
         scripts.append(templates.get(templateID));
         scripts.append("</script>");
      }
      
      return scripts;
   }
   
   protected LinkedHashMap<String, String> processTemplates()
   {
      @SuppressWarnings("unused")
      LinkedHashMap<String, String> templates = new LinkedHashMap<String, String>();
      processTemplate(this.component, templates);
      return templates;
   }
   
   private void processTemplate(Component<?, ?, ?> comp, LinkedHashMap<String, String> templates)
   {
      String templateID = comp.getTemplateID();
      if(!templates.containsKey(templateID))
      {
         String templateHTML = comp.getTemplateHTML();
         if(templateHTML != null)
            templates.put(templateID, templateHTML);
      }
      
      List<? extends Component<?, ?, ?>> children = comp.getComponents();
      if(children != null)
         for(Component<?, ?, ?> child : children)
            processTemplate(child, templates);
   }
   
   protected String toJSON()
      throws JsonProcessingException
   {
      return new ObjectMapper().writeValueAsString(this.component);
   }
   
   /**
    * @author SYESILDAG
    * @param output
    * @param element
    * @param scripts
    * @throws ResalysException
    * @throws JsonProcessingException 
    */
   public void bootstrap(Output output, String element, String scripts)
      throws JsonProcessingException
   {
      output.setVarValue( element, this.getComponent().getHTML() );
      output.setVarValue( scripts, this.getScripts() );
      output.appendOnDOMReadyJavascript( this.getBootstrapJS() );
      output.appendOnDOMReadyJavascript( this.getRenderJS() );
   }
   
   public static void main(String[] args)
   {
      //
   }
}