/*
 * Copyright 2008 University Corporation for Advanced Internet Development, Inc.
 * Copyright 2008 Members of the EGEE Collaboration.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.xacml.policy.impl;

import org.opensaml.xacml.policy.IdReferenceType;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.schema.impl.XSStringUnmarshaller;
import org.opensaml.xml.util.DatatypeHelper;
import org.w3c.dom.Attr;

/**
 * Unmarshaller for {@link IdReferenceType}.
 */
public class IdReferenceTypeUnmarshaller extends XSStringUnmarshaller {
  
    /** Constructor. */
    public IdReferenceTypeUnmarshaller() {
        super();
    }
    
    
    /** {@inheritDoc} */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        IdReferenceType idReferenceType = (IdReferenceType)xmlObject;
     
        if(attribute.getLocalName().equals(IdReferenceType.EARLIEST_VERSION_ATTRIB_NAME)){           
            idReferenceType.setEarliestVersion(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        }else if(attribute.getLocalName().equals(IdReferenceType.LATEST_VERSION_ATTRIB_NAME)){           
            idReferenceType.setLatestVersion(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        }else if(attribute.getLocalName().equals(IdReferenceType.VERSION_ATTRIB_NAME)){           
            idReferenceType.setVersion(DatatypeHelper.safeTrimOrNullString(attribute.getValue()));
        } else {
            super.processAttribute(xmlObject, attribute);
        }
    }

}
