package fr.pederobien.minecraftdevelopmenttoolkit.interfaces;

import org.bukkit.command.CommandExecutor;

/**
 * 
 * @author Pierre-Emmanuel
 *
 * @param <T> The type of the explanation.
 * @param <U> The type of element to add to this map edition.
 * @param <V> The type of the edition used to get the object to modify.
 * 
 * @see IManagedEdition
 * @see IAvailableEdition
 * @see IModifiableEdition
 * @see INodeEdition
 * @see CommandExecutor
 */
public interface IGenericMapEdition<T, U, V extends IManagedEdition<U>> extends IAvailableEdition<IGenericMapEdition<T, U, V>>, IModifiableEdition<IGenericMapEdition<T, U, V>>,
		INodeEdition<T, IGenericMapEdition<T, U, V>, IGenericMapEdition<T, U, V>>, CommandExecutor {

	/**
	 * Set the parent of this edition. This parent contains the object managed by this edition and all inherited interfaces/classes.
	 * 
	 * @param parent The parent that contains the object to modify by this edition.
	 */
	void setParent(V parent);

	/**
	 * @return the parent of this edition that contains the object to modify.
	 */
	V getParent();
}