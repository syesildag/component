package component;

import java.util.ArrayList;

public interface Component<D extends Data> {

    public static enum Namespace {
        JReactComponents
    }

    public String getSelector();
    public void setSelector(String selector);

    public String getName();
    public void setName(String name);

    public Namespace getNamespace();
    public void setNamespace(Namespace namespace);

    public String getTemplateID();
    public void setTemplateID(String templateID);

    public String getTemplateHTML();
    public void setTemplateHTML(String templateHTML);

    public D getData();
    public void setData(D data);

    public ArrayList<? extends Component<? extends Data>> getChildren();
    public void setChildren(ArrayList<? extends Component<? extends Data>> children);
}