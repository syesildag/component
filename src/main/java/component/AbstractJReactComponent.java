package component;

import java.util.ArrayList;

public abstract class AbstractJReactComponent<D extends Data> extends AbstractComponent<D> {

    public AbstractJReactComponent(String selector, D data, ArrayList<? extends Component<? extends Data>> children) {
        super(selector, Component.Namespace.JReactComponents, data, children);
    }
}