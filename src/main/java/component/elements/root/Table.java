/**
 * 
 */
package component.elements.root;

import java.util.Arrays;

import component.Component;
import component.Data;
import component.elements.sub.TableBody;
import component.elements.sub.TableHead;
import component.elements.sub.TableRow;
import component.AbstractComponent;
import component.AbstractRootComponent;

/**
 * @author SYESILDAG
 *
 */
public abstract class Table
<
D extends Data,
TRD extends Data,
TR extends TableRow<? extends TRD, ?, ?>,
THD extends Data,
TH extends TableHead<? extends THD, TRD, TR>,
TBD extends Data,
TB extends TableBody<? extends TBD, TRD, TR>
>
extends AbstractRootComponent<D, Data, AbstractComponent<? extends Data, TRD, TR>>
{
   public Table(String key, D data, TH tableHead, TB tableBody)
   {
      super(key, data, Arrays.asList(tableHead, tableBody));
   }
   
   /* (non-Javadoc)
    * @see com.resalys.engine.web.component.Component#getTag()
    */
   @Override
   public final Component.Tag getTag()
   {
      return Component.Tag.table;
   }
}
