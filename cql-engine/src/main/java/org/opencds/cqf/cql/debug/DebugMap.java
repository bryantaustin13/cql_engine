package org.opencds.cqf.cql.debug;

import org.cqframework.cql.elm.execution.Library;
import org.opencds.cqf.cql.elm.execution.Executable;

import java.util.HashMap;
import java.util.Map;

public class DebugMap {
    private Map<String, DebugLibraryMapEntry> libraryMaps;

    public DebugMap() {
        libraryMaps = new HashMap<String, DebugLibraryMapEntry>();
    }

    public boolean shouldDebug(Executable node, Library currentLibrary) {
        DebugLibraryMapEntry libraryMapEntry = libraryMaps.get(currentLibrary.getIdentifier().getId());
        if (libraryMapEntry != null) {
            return libraryMapEntry.shouldDebug(node);
        }

        return false;
    }

    public void addLibraryMapEntry(String libraryName, DebugLibraryMapEntry libraryMapEntry) {
        libraryMaps.put(libraryName, libraryMapEntry);
    }
}
