/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.apache.nutch.storage;  
@SuppressWarnings("all")
public class ParseStatus extends org.apache.gora.persistency.impl.PersistentBase implements org.apache.avro.specific.SpecificRecord, org.apache.gora.persistency.Persistent {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ParseStatus\",\"namespace\":\"org.apache.nutch.storage\",\"fields\":[{\"name\":\"__g__dirty\",\"type\":\"bytes\",\"doc\":\"Bytes used to represent weather or not a field is dirty.\",\"default\":\"AA==\"},{\"name\":\"majorCode\",\"type\":\"int\",\"default\":0},{\"name\":\"minorCode\",\"type\":\"int\",\"default\":0},{\"name\":\"args\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");

  /** Enum containing all data bean's fields. */
  public static enum Field {
    __G__DIRTY(0, "__g__dirty"),
    MAJOR_CODE(1, "majorCode"),
    MINOR_CODE(2, "minorCode"),
    ARGS(3, "args"),
    ;
    /**
     * Field's index.
     */
    private int index;

    /**
     * Field's name.
     */
    private String name;

    /**
     * Field's constructor
     * @param index field's index.
     * @param name field's name.
     */
    Field(int index, String name) {this.index=index;this.name=name;}

    /**
     * Gets field's index.
     * @return int field's index.
     */
    public int getIndex() {return index;}

    /**
     * Gets field's name.
     * @return String field's name.
     */
    public String getName() {return name;}

    /**
     * Gets field's attributes to string.
     * @return String field's attributes to string.
     */
    public String toString() {return name;}
  };

  public static final String[] _ALL_FIELDS = {
  "__g__dirty",
  "majorCode",
  "minorCode",
  "args",
  };

  /** Bytes used to represent weather or not a field is dirty. */
  private java.nio.ByteBuffer __g__dirty = java.nio.ByteBuffer.wrap(new byte[1]);
  private int majorCode;
  private int minorCode;
  private java.util.List<java.lang.CharSequence> args;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return __g__dirty;
    case 1: return majorCode;
    case 2: return minorCode;
    case 3: return args;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value) {
    switch (field$) {
    case 0: __g__dirty = (java.nio.ByteBuffer)(value); break;
    case 1: majorCode = (java.lang.Integer)(value); break;
    case 2: minorCode = (java.lang.Integer)(value); break;
    case 3: args = (java.util.List<java.lang.CharSequence>)((value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyListWrapper((java.util.List)value)); break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'majorCode' field.
   */
  public java.lang.Integer getMajorCode() {
    return majorCode;
  }

  /**
   * Sets the value of the 'majorCode' field.
   * @param value the value to set.
   */
  public void setMajorCode(java.lang.Integer value) {
    this.majorCode = value;
    setDirty(1);
  }
  
  /**
   * Checks the dirty status of the 'majorCode' field. A field is dirty if it represents a change that has not yet been written to the database.
   * @param value the value to set.
   */
  public boolean isMajorCodeDirty(java.lang.Integer value) {
    return isDirty(1);
  }

  /**
   * Gets the value of the 'minorCode' field.
   */
  public java.lang.Integer getMinorCode() {
    return minorCode;
  }

  /**
   * Sets the value of the 'minorCode' field.
   * @param value the value to set.
   */
  public void setMinorCode(java.lang.Integer value) {
    this.minorCode = value;
    setDirty(2);
  }
  
  /**
   * Checks the dirty status of the 'minorCode' field. A field is dirty if it represents a change that has not yet been written to the database.
   * @param value the value to set.
   */
  public boolean isMinorCodeDirty(java.lang.Integer value) {
    return isDirty(2);
  }

  /**
   * Gets the value of the 'args' field.
   */
  public java.util.List<java.lang.CharSequence> getArgs() {
    return args;
  }

  /**
   * Sets the value of the 'args' field.
   * @param value the value to set.
   */
  public void setArgs(java.util.List<java.lang.CharSequence> value) {
    this.args = (value instanceof org.apache.gora.persistency.Dirtyable) ? value : new org.apache.gora.persistency.impl.DirtyListWrapper(value);
    setDirty(3);
  }
  
  /**
   * Checks the dirty status of the 'args' field. A field is dirty if it represents a change that has not yet been written to the database.
   * @param value the value to set.
   */
  public boolean isArgsDirty(java.util.List<java.lang.CharSequence> value) {
    return isDirty(3);
  }

  /** Creates a new ParseStatus RecordBuilder */
  public static org.apache.nutch.storage.ParseStatus.Builder newBuilder() {
    return new org.apache.nutch.storage.ParseStatus.Builder();
  }
  
  /** Creates a new ParseStatus RecordBuilder by copying an existing Builder */
  public static org.apache.nutch.storage.ParseStatus.Builder newBuilder(org.apache.nutch.storage.ParseStatus.Builder other) {
    return new org.apache.nutch.storage.ParseStatus.Builder(other);
  }
  
  /** Creates a new ParseStatus RecordBuilder by copying an existing ParseStatus instance */
  public static org.apache.nutch.storage.ParseStatus.Builder newBuilder(org.apache.nutch.storage.ParseStatus other) {
    return new org.apache.nutch.storage.ParseStatus.Builder(other);
  }
  
  private static java.nio.ByteBuffer deepCopyToWriteOnlyBuffer(
      java.nio.ByteBuffer input) {
    java.nio.ByteBuffer copy = java.nio.ByteBuffer.allocate(input.capacity());
    int position = input.position();
    input.reset();
    int mark = input.position();
    int limit = input.limit();
    input.rewind();
    input.limit(input.capacity());
    copy.put(input);
    input.rewind();
    copy.rewind();
    input.position(mark);
    input.mark();
    copy.position(mark);
    copy.mark();
    input.position(position);
    copy.position(position);
    input.limit(limit);
    copy.limit(limit);
    return copy.asReadOnlyBuffer();
  }
  
  /**
   * RecordBuilder for ParseStatus instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ParseStatus>
    implements org.apache.avro.data.RecordBuilder<ParseStatus> {

    private java.nio.ByteBuffer __g__dirty;
    private int majorCode;
    private int minorCode;
    private java.util.List<java.lang.CharSequence> args;

    /** Creates a new Builder */
    private Builder() {
      super(org.apache.nutch.storage.ParseStatus.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.apache.nutch.storage.ParseStatus.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing ParseStatus instance */
    private Builder(org.apache.nutch.storage.ParseStatus other) {
            super(org.apache.nutch.storage.ParseStatus.SCHEMA$);
      if (isValidValue(fields()[0], other.__g__dirty)) {
        this.__g__dirty = (java.nio.ByteBuffer) data().deepCopy(fields()[0].schema(), other.__g__dirty);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.majorCode)) {
        this.majorCode = (java.lang.Integer) data().deepCopy(fields()[1].schema(), other.majorCode);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.minorCode)) {
        this.minorCode = (java.lang.Integer) data().deepCopy(fields()[2].schema(), other.minorCode);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.args)) {
        this.args = (java.util.List<java.lang.CharSequence>) data().deepCopy(fields()[3].schema(), other.args);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'majorCode' field */
    public java.lang.Integer getMajorCode() {
      return majorCode;
    }
    
    /** Sets the value of the 'majorCode' field */
    public org.apache.nutch.storage.ParseStatus.Builder setMajorCode(int value) {
      validate(fields()[1], value);
      this.majorCode = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'majorCode' field has been set */
    public boolean hasMajorCode() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'majorCode' field */
    public org.apache.nutch.storage.ParseStatus.Builder clearMajorCode() {
      fieldSetFlags()[1] = false;
      return this;
    }
    
    /** Gets the value of the 'minorCode' field */
    public java.lang.Integer getMinorCode() {
      return minorCode;
    }
    
    /** Sets the value of the 'minorCode' field */
    public org.apache.nutch.storage.ParseStatus.Builder setMinorCode(int value) {
      validate(fields()[2], value);
      this.minorCode = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'minorCode' field has been set */
    public boolean hasMinorCode() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'minorCode' field */
    public org.apache.nutch.storage.ParseStatus.Builder clearMinorCode() {
      fieldSetFlags()[2] = false;
      return this;
    }
    
    /** Gets the value of the 'args' field */
    public java.util.List<java.lang.CharSequence> getArgs() {
      return args;
    }
    
    /** Sets the value of the 'args' field */
    public org.apache.nutch.storage.ParseStatus.Builder setArgs(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[3], value);
      this.args = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'args' field has been set */
    public boolean hasArgs() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'args' field */
    public org.apache.nutch.storage.ParseStatus.Builder clearArgs() {
      args = null;
      fieldSetFlags()[3] = false;
      return this;
    }
    
    @Override
    public ParseStatus build() {
      try {
        ParseStatus record = new ParseStatus();
        record.__g__dirty = fieldSetFlags()[0] ? this.__g__dirty : (java.nio.ByteBuffer) java.nio.ByteBuffer.wrap(new byte[1]);
        record.majorCode = fieldSetFlags()[1] ? this.majorCode : (java.lang.Integer) defaultValue(fields()[1]);
        record.minorCode = fieldSetFlags()[2] ? this.minorCode : (java.lang.Integer) defaultValue(fields()[2]);
        record.args = fieldSetFlags()[3] ? this.args : (java.util.List<java.lang.CharSequence>) new org.apache.gora.persistency.impl.DirtyListWrapper((java.util.List)defaultValue(fields()[3]));
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
  
  public ParseStatus.Tombstone getTombstone(){
  	return TOMBSTONE;
  }

  public ParseStatus newInstance(){
    return newBuilder().build();
  }

  private static final Tombstone TOMBSTONE = new Tombstone();
  
  public static final class Tombstone extends ParseStatus implements org.apache.gora.persistency.Tombstone {
  
      private Tombstone() { }
  
	  				  /**
	   * Gets the value of the 'majorCode' field.
		   */
	  public java.lang.Integer getMajorCode() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'majorCode' field.
		   * @param value the value to set.
	   */
	  public void setMajorCode(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'majorCode' field. A field is dirty if it represents a change that has not yet been written to the database.
		   * @param value the value to set.
	   */
	  public boolean isMajorCodeDirty(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the 'minorCode' field.
		   */
	  public java.lang.Integer getMinorCode() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'minorCode' field.
		   * @param value the value to set.
	   */
	  public void setMinorCode(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'minorCode' field. A field is dirty if it represents a change that has not yet been written to the database.
		   * @param value the value to set.
	   */
	  public boolean isMinorCodeDirty(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the 'args' field.
		   */
	  public java.util.List<java.lang.CharSequence> getArgs() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the 'args' field.
		   * @param value the value to set.
	   */
	  public void setArgs(java.util.List<java.lang.CharSequence> value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the 'args' field. A field is dirty if it represents a change that has not yet been written to the database.
		   * @param value the value to set.
	   */
	  public boolean isArgsDirty(java.util.List<java.lang.CharSequence> value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
		  
  }
  
}