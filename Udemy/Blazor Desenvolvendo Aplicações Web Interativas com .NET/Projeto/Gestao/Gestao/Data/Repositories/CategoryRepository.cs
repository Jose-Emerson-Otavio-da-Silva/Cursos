using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Gestao.Client.Libraries.Utilities;
using Gestao.Domain;
using Microsoft.EntityFrameworkCore;

namespace Gestao.Data.Repositories
{
    /// <summary>
    /// Interface para CategoryRepository
    public interface ICategoryRepository
    {
        Task Add(Category entity);
        Task Delete(int id);
        Task<Category?> Get(int id);
        Task<PaginatedList<Category>> GetAll(int companyId, int pageIndex, int pageSize);
        Task<List<Category>> GetAll(int companyId);
        Task Update(Category entity);
    }

    /// <summary>
    /// Repository implementation for the Category entity
    /// </summary>
    public class CategoryRepository : ICategoryRepository
    {
        private readonly ApplicationDbContext _context; // Database context

        // Constructor that receives the database context via dependency injection
        public CategoryRepository(ApplicationDbContext context)
        {
            _context = context;
        }

        /// <summary>
        /// Retrieves a paginated list of categories associated with a company
        /// </summary>
        /// <param name="companyId">Company ID</param>
        /// <param name="pageIndex">Current page index</param>
        /// <param name="pageSize">Number of items per page</param>
        /// <returns>Paginated list of categories</returns>
        public async Task<PaginatedList<Category>> GetAll(int companyId, int pageIndex, int pageSize)
        {
            // Retrieves the items for the current page
            var items = await _context.Categories
                .Where(a => a.CompanyId == companyId) // Filters categories by company ID
                .Skip((pageIndex - 1) * pageSize) // Skips items from previous pages
                .Take(pageSize) // Selects items for the current page
                .ToListAsync();

            // Counts the total number of categories associated with the company
            var count = await _context.Categories
                .Where(a => a.CompanyId == companyId).CountAsync();

            // Calculates the total number of pages
            int totalPages = (int)Math.Ceiling((decimal)count / pageSize);

            // Returns the paginated list
            return new PaginatedList<Category>(items, pageIndex, totalPages);
        }

        /// <summary>
        /// Retrieves all categories associated with a company
        /// </summary>
        /// <param name="companyId">Company ID</param>
        /// <returns>List of categories</returns>
        public async Task<List<Category>> GetAll(int companyId)
        {
            return await _context.Categories
                .Where(a => a.CompanyId == companyId)
                .ToListAsync();
        }

        /// <summary>
        /// Retrieves a category by its ID
        /// </summary>
        /// <param name="id">Category ID</param>
        /// <returns>Category found or null</returns>
        public async Task<Category?> Get(int id)
        {
            return await _context.Categories.SingleOrDefaultAsync(a => a.Id == id);
        }

        /// <summary>
        /// Adds a new category
        /// </summary>
        /// <param name="entity">Category to be added</param>
        /// <returns></returns>
        public async Task Add(Category entity)
        {
            _context.Categories.Add(entity); // Adds the category to the context
            await _context.SaveChangesAsync(); // Saves changes to the database
        }

        /// <summary>
        /// Updates the data of a category
        /// </summary>
        /// <param name="entity">Category to be updated</param>
        /// <returns></returns>
        public async Task Update(Category entity)
        {
            _context.Categories.Update(entity); // Updates the category in the context
            await _context.SaveChangesAsync(); // Saves changes to the database
        }

        /// <summary>
        /// Removes a category by its ID
        /// </summary>
        /// <param name="id">Category ID</param>
        /// <returns></returns>
        public async Task Delete(int id)
        {
            var entity = await Get(id); // Retrieves the category by its ID
            if (entity is not null) // Checks if the category exists
            {
                _context.Categories.Remove(entity); // Removes the category from the context
                await _context.SaveChangesAsync(); // Saves changes to the database
            }
        }
    }
}