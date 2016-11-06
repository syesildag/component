package component;

public class CompoundProductItemComponent extends AbstractJReactComponent<CompoundProductItemData> {

    public CompoundProductItemComponent(String selector, CompoundProductItemData data) {
        super(selector, data, null);
    }

    @Override
    public String getTemplateHTML() {
        return "<span data-code/><span data-quantity/>";
    }
}