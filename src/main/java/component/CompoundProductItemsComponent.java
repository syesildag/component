package component;

import java.util.ArrayList;

public class CompoundProductItemsComponent extends AbstractJReactComponent<Data> {

    public CompoundProductItemsComponent(String selector, ArrayList<CompoundProductItemComponent> children) {
        super(selector, null, children);
    }
}