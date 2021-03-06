/*
 * Copyright (c) 2003, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: SubsetReplaceCommand.java,v 1.4 2007/01/04 18:53:35 khussey Exp $
 */
package org.eclipse.uml2.common.edit.command;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

@Deprecated
public class SubsetReplaceCommand
		extends SubsetCommand {

	protected final Object value;

	protected final Collection<?> collection;

	public SubsetReplaceCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, EStructuralFeature[] supersetFeatures,
			Object value, Collection<?> collection) {

		super(domain, owner, feature, supersetFeatures, new ReplaceCommand(
			domain, owner, feature, value, collection));

		this.value = value;
		this.collection = collection;
	}

	@Override
	public void execute() {

		if (supersetFeatures != null) {

			for (Object element : collection) {

				for (int i = 0; i < supersetFeatures.length; i++) {

					if (supersetFeatures[i].isMany()) {
						@SuppressWarnings("unchecked")
						EList<EObject> values = (EList<EObject>) owner
							.eGet(supersetFeatures[i]);

						if (!values.contains(element)) {
							appendAndExecute(AddCommand.create(domain, owner,
								supersetFeatures[i], Collections
									.singleton(element),
								CommandParameter.NO_INDEX));
						}
					}
				}
			}
		}

		super.execute();
	}
}