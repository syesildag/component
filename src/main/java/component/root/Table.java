/**
 * 
 */
package component.root;

import java.util.Arrays;

import component.AbstractComponent;
import component.AbstractRootComponent;
import component.Component;
import component.Data;
import component.sub.TableBody;
import component.sub.TableHead;
import component.sub.TableRow;

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
   public Table(String key, Component.NameSpace nameSpace, D data, TH tableHead, TB tableBody)
   {
      super(key, nameSpace, data, Arrays.asList(tableHead, tableBody));
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
