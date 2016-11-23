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
public abstract class TableBody<D extends Data, TRD extends Data, TR extends TableRow<? extends TRD, ?, ?>> extends AbstractComponent<D, TRD, TR>
{
   public TableBody()
   {
   }
   
   /**
    * @param key
    * @param data
    * @param children
    */
   public TableBody(String key, Component.NameSpace nameSpace, D data, List<? extends TR> children)
   {
      super(key, nameSpace, data, children);
   }
   
   /* (non-Javadoc)
    * @see com.resalys.engine.web.component.Component#getTag()
    */
   @Override
   public final Tag getTag()
   {
      return Tag.tbody;
   }
}
