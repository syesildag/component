package component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public abstract class AbstractComponent<D extends Data> implements Component<D> {
    private String selector;
    private Component.Namespace namespace;
    private D data;
    private ArrayList<? extends Component<? extends Data>> children;

    public AbstractComponent(String selector, Component.Namespace namespace, D data, ArrayList<? extends Component<? extends Data>> children) {
        this.selector = selector;
        this.namespace = namespace;
        this.data = data;
        this.children = children;
    }

    @JsonIgnore
    public String getHTML() {
        return "<span name='"+this.selector+"' data-jreact-"+this.namespace.name().toLowerCase()+"-"+this.getName().toLowerCase()+"/>";
    }

    @JsonProperty
    @Override
    public final String getSelector() {
        return this.selector;
    }

    @JsonIgnore
    @Override
    public final void setSelector(String name) {
    }

    @JsonProperty
    @Override
    public final String getName() {
        return this.getClass().getSimpleName();
    }

    @JsonIgnore
    @Override
    public final void setName(String name) {
    }

    @Override
    public final Component.Namespace getNamespace() {
        return this.namespace;
    }

    @Override
    public final void setNamespace(Component.Namespace namespace) {
        this.namespace = namespace;
    }

    @JsonProperty
    @Override
    public final String getTemplateID() {
        return this.getClass().getName();
    }

    @JsonIgnore
    @Override
    public final void setTemplateID(String templateID) {
    }

    @JsonIgnore
    @Override
    public String getTemplateHTML() {
        return null;
    }

    @JsonIgnore
    @Override
    public void setTemplateHTML(String templateHTML) {
    }

    @Override
    public final D getData() {
        return this.data;
    }

    @Override
    public final void setData(D data) {
        this.data = data;
    }

    @Override
    public final ArrayList<? extends Component<? extends Data>> getChildren() {
        return this.children;
    }

    @Override
    public final void setChildren(ArrayList<? extends Component<? extends Data>> children) {
        this.children = children;
    }
}