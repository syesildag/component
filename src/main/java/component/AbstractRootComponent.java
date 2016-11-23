/**
 * @author SYESILDAG
 */
package component;

import java.util.List;

public abstract class AbstractRootComponent<D extends Data, T extends Data, C extends AbstractComponent<? extends T, ?, ?>> extends AbstractComponent<D, T, C> {

   public AbstractRootComponent() {
   }
   
   public AbstractRootComponent(String key, Component.NameSpace nameSpace, D data, List<? extends C> children) {
      super(key, nameSpace, data, children);
   }
}