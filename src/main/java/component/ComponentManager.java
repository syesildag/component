package component;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ComponentManager <C extends Component<? extends Data>> {
    private C component;

    public ComponentManager() {
    }

    public ComponentManager(C component) {
        this.component = component;
    }

    public String getBootstrapJS() {
        return "JReact.bootstrap(document)";
    }

    public LinkedHashMap<String, String> processTemplates() {
        LinkedHashMap<String, String> templates = new LinkedHashMap<String, String>();
        processTemplate(this.component, templates);
        return templates;
    }

    private <T extends Component<? extends Data>> void processTemplate(T component, LinkedHashMap<String, String> templates) {

        String templateID = component.getTemplateID();
        if(!templates.containsKey(templateID)) {
            String templateHTML = component.getTemplateHTML();
            if(templateHTML != null)
                templates.put(templateID, templateHTML);
        }

        ArrayList<? extends Component<? extends Data>> children = component.getChildren();
        if(children != null)
            for (Component<? extends Data> child : children)
                processTemplate(child, templates);
    }
    
    public Object toJSON() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this.component);
    }

    public static void main(String[] args) throws JsonProcessingException {

        CompoundProductItemComponent pc2 = new CompoundProductItemComponent("PC2", new CompoundProductItemData("PC", 2));
        CompoundProductItemComponent loc5 = new CompoundProductItemComponent("LOC5", new CompoundProductItemData("LOC", 5));
        CompoundProductItemsComponent items = new CompoundProductItemsComponent("items", new ArrayList<CompoundProductItemComponent>(Arrays.asList(pc2, loc5)));

        ComponentManager<CompoundProductItemsComponent> cm = new ComponentManager<CompoundProductItemsComponent>(items);
        LinkedHashMap<String, String> templates = cm.processTemplates();

        for(String templateID : templates.keySet()) {
            System.out.println("templateID: " + templateID);
            System.out.println("templateHTML: " + templates.get(templateID));
        }

        System.out.println("toJSON: " + cm.toJSON());
    }
}