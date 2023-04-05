package org.eclipse.tsp.java.client.api.bookmark;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.jcabi.aspects.Async;
import com.jcabi.aspects.Loggable;

public class BookmarkAsyncApi {
	private BookmarkApi bookmarkApi;

	public BookmarkAsyncApi(String baseUrl) {
		this.bookmarkApi = new BookmarkApi(baseUrl);
	}

	@Async
	@Loggable
	public CompletableFuture<List<Bookmark>> getBookmarks(UUID experimentUuid) {
		return CompletableFuture.supplyAsync(() -> this.bookmarkApi.getBookmarks(experimentUuid));
	}

	@Async
	@Loggable
	public CompletableFuture<Bookmark> getBookmark(UUID experimentUuid, UUID bookmarkUuid) {
		return CompletableFuture.supplyAsync(() -> this.bookmarkApi.getBookmark(experimentUuid, bookmarkUuid));
	}

	@Async
	@Loggable
	public CompletableFuture<Bookmark> createBookmark(UUID experimentUuid, Bookmark bookmark) {
		return CompletableFuture.supplyAsync(() -> this.bookmarkApi.createBookmark(experimentUuid, bookmark));
	}

	@Async
	@Loggable
	public CompletableFuture<Bookmark> updateBookmark(UUID experimentUuid, UUID bookmarkUuid, Bookmark bookmark) {
		return CompletableFuture
				.supplyAsync(() -> this.bookmarkApi.updateBookmark(experimentUuid, bookmarkUuid, bookmark));
	}

	@Async
	@Loggable
	public CompletableFuture<Bookmark> deleteBookmark(UUID experimentUuid, UUID bookmarkUuid) {
		return CompletableFuture.supplyAsync(() -> this.bookmarkApi.deleteBookmark(experimentUuid, bookmarkUuid));
	}
}
