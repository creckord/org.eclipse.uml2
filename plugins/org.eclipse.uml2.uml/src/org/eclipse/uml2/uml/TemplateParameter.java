/*
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *
 * $Id: TemplateParameter.java,v 1.2 2005/11/22 15:32:38 khussey Exp $
 */
package org.eclipse.uml2.uml;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TemplateParameter references a ParameterableElement which is exposed as a formal template parameter in the containing template.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.TemplateParameter#getSignature <em>Signature</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateParameter#getOwnedParameteredElement <em>Owned Parametered Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateParameter#getDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateParameter#getOwnedDefault <em>Owned Default</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.TemplateParameter#getParameteredElement <em>Parametered Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter()
 * @model
 * @generated
 */
public interface TemplateParameter
		extends Element {

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.TemplateSignature#getOwnedParameters <em>Owned Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The template signature that owns this template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signature</em>' container reference.
	 * @see #setSignature(TemplateSignature)
	 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter_Signature()
	 * @see org.eclipse.uml2.uml.TemplateSignature#getOwnedParameters
	 * @model opposite="ownedParameter" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	TemplateSignature getSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.TemplateParameter#getSignature <em>Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' container reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(TemplateSignature value);

	/**
	 * Returns the value of the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.ParameterableElement#getOwningTemplateParameter <em>Owning Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is owned by this template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parametered Element</em>' containment reference.
	 * @see #setOwnedParameteredElement(ParameterableElement)
	 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter_OwnedParameteredElement()
	 * @see org.eclipse.uml2.uml.ParameterableElement#getOwningTemplateParameter
	 * @model opposite="owningTemplateParameter" containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	ParameterableElement getOwnedParameteredElement();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.TemplateParameter#getOwnedParameteredElement <em>Owned Parametered Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Parametered Element</em>' containment reference.
	 * @see #getOwnedParameteredElement()
	 * @generated
	 */
	void setOwnedParameteredElement(ParameterableElement value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.ParameterableElement} and sets the '<em><b>Owned Parametered Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.ParameterableElement} to create.
	 * @return The new {@link org.eclipse.uml2.uml.ParameterableElement}.
	 * @see #getOwnedParameteredElement()
	 * @generated
	 */
	ParameterableElement createOwnedParameteredElement(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is the default for this formal template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' reference.
	 * @see #setDefault(ParameterableElement)
	 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter_Default()
	 * @model ordered="false"
	 * @generated
	 */
	ParameterableElement getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.TemplateParameter#getDefault <em>Default</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(ParameterableElement value);

	/**
	 * Returns the value of the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that is owned by this template parameter for the purpose of providing a default.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Default</em>' containment reference.
	 * @see #setOwnedDefault(ParameterableElement)
	 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter_OwnedDefault()
	 * @model containment="true" resolveProxies="false" ordered="false"
	 * @generated
	 */
	ParameterableElement getOwnedDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.TemplateParameter#getOwnedDefault <em>Owned Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Default</em>' containment reference.
	 * @see #getOwnedDefault()
	 * @generated
	 */
	void setOwnedDefault(ParameterableElement value);

	/**
	 * Creates a {@link org.eclipse.uml2.uml.ParameterableElement} and sets the '<em><b>Owned Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.uml2.uml.ParameterableElement} to create.
	 * @return The new {@link org.eclipse.uml2.uml.ParameterableElement}.
	 * @see #getOwnedDefault()
	 * @generated
	 */
	ParameterableElement createOwnedDefault(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Parametered Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.ParameterableElement#getTemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element exposed by this template parameter.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parametered Element</em>' reference.
	 * @see #setParameteredElement(ParameterableElement)
	 * @see org.eclipse.uml2.uml.UMLPackage#getTemplateParameter_ParameteredElement()
	 * @see org.eclipse.uml2.uml.ParameterableElement#getTemplateParameter
	 * @model opposite="templateParameter" required="true" ordered="false"
	 * @generated
	 */
	ParameterableElement getParameteredElement();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.TemplateParameter#getParameteredElement <em>Parametered Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parametered Element</em>' reference.
	 * @see #getParameteredElement()
	 * @generated
	 */
	void setParameteredElement(ParameterableElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The default must be compatible with the formal template parameter.
	 * default->notEmpty() implies default->isCompatibleWith(parameteredElement)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateMustBeCompatible(DiagnosticChain diagnostics, Map context);

} // TemplateParameter