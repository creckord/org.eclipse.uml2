/*
 * Copyright (c) 2008, 2011 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (CEA) - 327039
 *
 */
package org.eclipse.uml2.uml.internal.resource;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.uml2.uml.resource.UML212UMLExtendedMetaData;
import org.eclipse.uml2.uml.resource.UML302UMLResource;

/**
 * Handler that converts .uml models.
 * OMG:  UML 2.1.x and UML 2.2 
 * API:  UML2 2.2.x and UML2 3.0.x 
 * 
 * @since 3.0
 */
public class UML212UMLHandler
		extends UMLHandler {

	protected static final String STANDARD_L3_PROFILE_NS_PREFIX = "l3"; //$NON-NLS-1$

	protected static final String STANDARD_PROFILE_NS_PREFIX = "Standard"; //$NON-NLS-1$

	protected static final String STEREOTYPE__BUILD_COMPONENT = "BuildComponent"; //$NON-NLS-1$

	protected static final String STEREOTYPE__METAMODEL = "Metamodel"; //$NON-NLS-1$

	protected static final String STEREOTYPE__SYSTEM_MODEL = "SystemModel"; //$NON-NLS-1$

	public UML212UMLHandler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}

	@Override
	protected void createObject(EObject peekObject, EStructuralFeature feature) {

		if (!isNull()) {
			String xsiType = getXSIType();

			Map<String, Map<EClassifier, String>> featureToTypeMap = xsiType == null
				? UML212UMLExtendedMetaData.getFeatureToTypeMap()
				: null;

			Map<EClassifier, String> typeMap = featureToTypeMap == null
				? null
				: featureToTypeMap.get(feature.getName());

			if (typeMap != null) {
				EObject eObject = peekObject instanceof AnyType
					? (EObject) objects.get(objects.size() - 2)
					: peekObject;

				for (Map.Entry<EClassifier, String> entry : typeMap.entrySet()) {

					if (entry.getKey().isInstance(eObject)) {
						xsiType = entry.getValue();
						break;
					}
				}
			}

			if (xsiType != null) {
				createObjectFromTypeName(peekObject, xsiType, feature);
			} else {
				super.createObject(peekObject, feature);
			}
		}
	}

	@Override
	protected EObject createObjectByType(String prefix, String name, boolean top) {
		return super
			.createObjectByType(
				STANDARD_PROFILE_NS_PREFIX.equals(prefix)
					&& (STEREOTYPE__BUILD_COMPONENT.equals(name)
						|| STEREOTYPE__METAMODEL.equals(name) || STEREOTYPE__SYSTEM_MODEL
							.equals(name))
					? STANDARD_L3_PROFILE_NS_PREFIX
					: prefix, name, top);
	}

	@Override
	protected EFactory getFactoryForPrefix(String prefix) {

		if (STANDARD_L3_PROFILE_NS_PREFIX.equals(prefix)) {
			EFactory factory = prefixesToFactories.get(prefix);

			if (factory == null) {
				EPackage ePackage = getPackageForURI(UML302UMLResource.STANDARD_L3_PROFILE_NS_URI);

				if (ePackage != null) {
					factory = ePackage.getEFactoryInstance();
					prefixesToFactories.put(prefix, factory);
				}
			}

			return factory;
		}

		return super.getFactoryForPrefix(prefix);
	}

}
