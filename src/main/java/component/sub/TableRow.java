/**
 * 
 */
package component.sub;

import java.util.List;

import component.AbstractComponent;
import component.Component;
import component.Data;

/**
 * @author SYESILDAG
 *
 */
public abstract class TableRow<D extends Data, T extends Data, C extends TableData<? extends T, ?, ?>> extends AbstractComponent<D, T, C>
{
   public TableRow()
   {
   }
   
   public TableRow(String key, Component.NameSpace nameSpace, D data, List<? extends C> children)
   {
      super(key, nameSpace, data, children);
   }
   
   /* (non-Javadoc)
    * @see com.resalys.engine.web.component.Component#getTag()
    */
   @Override
   public final Tag getTag()
   {
      return Tag.tr;
   }
}
