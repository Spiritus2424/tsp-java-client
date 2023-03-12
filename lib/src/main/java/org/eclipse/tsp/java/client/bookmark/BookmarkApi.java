package org.eclipse.tsp.java.client.bookmark;

import java.util.List;
import java.util.UUID;

import org.eclipse.tsp.java.client.tsp.AbstractTspApi;

public class BookmarkApi extends AbstractTspApi {
    private final String BOOKMARK_API_URL = "%s/experiments/{expUUID}/bookmarks";

    public BookmarkApi(String baseUrl) {
        super(baseUrl);
    }

    public List<Bookmark> getBookmarks(UUID experimentUuid) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Bookmark getBookmark(UUID experimentUuid, UUID bookmarkUuid) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Bookmark createBookmark(UUID experimentUuid, Bookmark bookmark) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Bookmark updateBookmark(UUID experimentUuid, UUID bookmarkUuid, Bookmark bookmark) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    public Bookmark deleteBookmark(UUID experimentUuid, UUID bookmarkUuid) {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
