/**
 * 
 */
package component.sub;

import java.util.List;

import component.AbstractComponent;
import component.AbstractRootComponent;
import component.Component;
import component.Data;

/**
 * @author SYESILDAG
 *
 */
public abstract class TableData<D extends Data, T extends Data, C extends AbstractRootComponent<? extends T, ?, ?>> extends AbstractComponent<D, T, C>
{
   public TableData()
   {
   }
   
   public TableData(String key, Component.NameSpace nameSpace, D data, List<? extends C> children)
   {
      super(key, nameSpace, data, children);
   }
   
   /* (non-Javadoc)
    * @see com.resalys.engine.web.component.Component#getTag()
    */
   @Override
   public final Tag getTag()
   {
      return Tag.td;
   }
}
