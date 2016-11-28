/**
 * 
 */
package component.elements.sub;

import java.util.List;

import component.AbstractComponent;
import component.Data;

/**
 * @author SYESILDAG
 *
 */
public abstract class TableHead<D extends Data, TRD extends Data, TR extends TableRow<? extends TRD, ?, ?>> extends AbstractComponent<D, TRD, TR>
{
   public TableHead()
   {
   }
   
   /**
    * @param key
    * @param data
    * @param children
    */
   public TableHead(String key, D data, List<? extends TR> children)
   {
      super(key, data, children);
   }
   
   /* (non-Javadoc)
    * @see com.resalys.engine.web.component.Component#getTag()
    */
   @Override
   public final Tag getTag()
   {
      return Tag.thead;
   }
}
